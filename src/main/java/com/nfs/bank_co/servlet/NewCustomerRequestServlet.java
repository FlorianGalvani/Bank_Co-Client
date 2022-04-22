package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.NewCustomerRequest;
import com.nfs.bank_co.utils.FormToolBox;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "NewCustomerRequestServlet", urlPatterns = {"/newcustomer"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class NewCustomerRequestServlet extends HttpServlet {

    /*
     *  Chemins dans lesquels les documents seront sauvegardées.
     */

    public static String DOCUMENTS_FOLDER = "/New_Customers_Documents";

    public String IdCardUploadPath;

    /*
     *  Si les dossiers de sauvegarde des images n'existe pas,
     *  on demande leurs créations.
     */

    @Override
    public void init() throws ServletException {
        IdCardUploadPath = getServletContext().getRealPath( DOCUMENTS_FOLDER ) + "/id_card";
//        System.out.println("idcard upload path " + IdCardUploadPath);
        File uploadDir = new File(IdCardUploadPath);
        if ( !uploadDir.exists() ) uploadDir.mkdir();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * Redirige les requetes de /newcustomer vers /newcustomer.jsp (Formulaire de demande d'ouverture d'un compte client).
         */
        response.sendRedirect(request.getContextPath() + "/newcustomer.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();
        /*
         *  Creation d'une nouvelle demande d'ouverture de compte et
         *  verification et ajout des different(e)s informations
         *  et documents
         *  TODO Verification de la presence et la validité des infos/docus
         *   + Trim des infos
         *   + verification si la demande n'est pas déja presente
         */

        NewCustomerRequest newCustomerRequest = new NewCustomerRequest();

        String title = request.getParameter("title").trim();
        FormToolBox.checkStringValidity(errors,"title",title,6,9);

        String firstname = request.getParameter("firstname").trim();
        FormToolBox.checkStringValidity(errors,"firstname",firstname,3,20);

        String lastname = request.getParameter("lastname").trim();
        FormToolBox.checkStringValidity(errors,"lastname",lastname,3,20);

        String phone = request.getParameter("phone").trim();
        FormToolBox.checkStringValidity(errors,"phone",phone,10,20);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        try {
            if (!request.getParameter("birthdate").isEmpty()) {
                newCustomerRequest.setBirthdate(format.parse(request.getParameter("birthdate").trim()));
            } else {
                errors.put("birthdate","Veuillez renseigner ce champ");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String address = request.getParameter("address").trim();
        FormToolBox.checkStringValidity(errors,"address",address,10,200);

        String city = request.getParameter("city").trim();
        FormToolBox.checkStringValidity(errors,"city",city,2,50);

        String postal = request.getParameter("postal").trim();
        FormToolBox.checkStringValidity(errors,"postal",postal,2,50);

        String country = request.getParameter("country").trim();
        FormToolBox.checkStringValidity(errors,"country",country,2,50);

        /*
         * Ajout des documents
         *  TODO modifier l'emplacement d'enregistrement des documents
         *  TODO VERIFICATION/VALIDATION du/des documents (taille,dimensions,format...)
         *  type de fichier possible pdf, docx, doc, jpg, png, txt, rtf, jpeg, jpe, jif, jfif, gif, tif, tiff
         */

        Part idCardPart = request.getPart("idCard");
        System.out.println( "idCardPart " + idCardPart.getSize());
        String idCardFileName = "idCard_" + lastname + "_" + firstname + ".png";
        String idCardFullPath = IdCardUploadPath + File.separator + idCardFileName;
        if (idCardPart.getSize() == 0) {
            errors.put("idCard","Veuillez ajouter un document");
        }

        if (errors.size() == 0) {
            newCustomerRequest.setTitle(title);
            newCustomerRequest.setFirstname(firstname);
            newCustomerRequest.setFirstname(lastname);
            newCustomerRequest.setFirstname(phone);
            newCustomerRequest.setAddress(address);
            newCustomerRequest.setCity(city);
            newCustomerRequest.setPostal(postal);
            newCustomerRequest.setCountry(country);

            idCardPart.write( idCardFullPath );
            newCustomerRequest.setIdCard(idCardFileName);

            System.out.println("Nouvelle demande d'ouverture de compte de la part de " + request.getParameter("firstname") + " " + request.getParameter("lastname"));
            DaoFactory.getNewCustomerRequestDao().create(newCustomerRequest);
        } else {

            /*
             * TODO Faire en sorte que les (certaines ?) données persistent apres l'envoi du formulaire si il est invalide
             */
            request.getSession().setAttribute("errors",errors);
            response.sendRedirect(request.getContextPath() + "/newcustomer.jsp");
        }
    }
}
