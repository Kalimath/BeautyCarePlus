package ui.controller;

import domain.model.personal.Address;
import domain.model.personal.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddClient extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


//            RequestHandler returning = new FindClient();
//            returning.setModel(this.getDatabaseService());
//            returning.handleRequest(request,response);
            //RequestDispatcher view = request.getRequestDispatcher("clients.jsp");
            //view.forward(request,response);


        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("phone");
        /*String dayString = request.getParameter("day");
        String monthString = request.getParameter("month");
        String yearString = request.getParameter("year");*/
        String birthdayString = request.getParameter("birthday");
        String place = request.getParameter("place");
        String zip = request.getParameter("zip");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String comment = request.getParameter("comment");

        Client temp = new Client();
        List<String> errors = new ArrayList<>();

        try{
            temp.setName(name);
        }catch (Exception ex){
            errors.add(ex.getMessage());
        }


         try {
            temp.setEmail(email);
            request.setAttribute("previousValueEmail", email);
        }catch (Exception exc){
            errors.add(exc.getMessage());
        }
        try {
            temp.setPhone(tel);
            request.setAttribute("previousValuePhone", tel);
        }catch (Exception exc){
            errors.add(exc.getMessage());
        }
        try {
            System.out.println(birthdayString);
           /* int day = Integer.parseInt(dayString);
            int year = Integer.parseInt(monthString);
            int month = Integer.parseInt(yearString);*/
            //temp.setBirthDate(LocalDate.parse(birthdayString,DateTimeFormatter.ofPattern("YYYY-MM-DD")));
            temp.setBirthDate(LocalDate.parse(birthdayString));
            request.setAttribute("previousValueBirthday",birthdayString);
        }catch (Exception exc){
            errors.add("geboortedatum is leeg");
        }
        try {
            temp.setComment(comment);
            request.setAttribute("previousValueComment", comment);
        }catch (Exception exc){
            errors.add(exc.getMessage());
        }

            //address
            Address tempAddress = null;
            try {
                tempAddress = new Address();
            }catch (Exception e){

            }
            try {

                tempAddress.setPlace(place);
                request.setAttribute("previousValuePlace", place);
            }catch (Exception e){
            errors.add(e.getMessage());
            }
            try {
                int zipInt = Integer.parseInt(zip);
                tempAddress.setZip(zipInt);
                request.setAttribute("previousValuePlace", place);
            }catch (Exception e){
                errors.add("postcode is niet geldig");
            }
            try {
                tempAddress.setStreet(street);
                request.setAttribute("previousValueStreet", street);
            }catch (Exception e){
                errors.add(e.getMessage());
            }
            try {
                tempAddress.setNumber(number);
                request.setAttribute("previousValueNumber", number);
            }catch (Exception e){
                errors.add(e.getMessage());
            }

        String dest = "clientForm.jsp";

        if(super.getDatabaseService().getAllClients().contains(temp)){
            response.sendRedirect("clientForm.jsp");
        }else if(temp!=null) {
            if (errors.size() > 0) {
                request.setAttribute("errors", errors);
                dest = "clientForm.jsp";
            } else {
                try {
                    this.getDatabaseService().addClient(temp);
                    this.getDatabaseService().addAddress(getDatabaseService().getClientId(temp.getName()),tempAddress);
                    request.getSession().setAttribute("client",temp);
                    request.getSession().setAttribute("clientAddress",tempAddress);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                dest = "clientView.jsp";
            }
            RequestDispatcher view = request.getRequestDispatcher(dest);
            view.forward(request,response);
        }



    }
}
