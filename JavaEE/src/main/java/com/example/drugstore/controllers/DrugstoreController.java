package com.example.drugstore.controllers;

import com.example.drugstore.entities.Drugstore;
import com.example.drugstore.services.DrugstoreService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/drugstores")
public class DrugstoreController extends HttpServlet {

    @EJB
    private DrugstoreService drugstoreService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("drugstores", drugstoreService.getAllDrugStores());
            request.getRequestDispatcher("drugstore.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");

            Drugstore drugstore = new Drugstore();
            drugstore.setName(name);
            drugstore.setAddress(address);

            drugstoreService.createDrugStore(drugstore);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            drugstoreService.deleteDrugStore(id);

        }

        doGet(request, response);
    }
}
