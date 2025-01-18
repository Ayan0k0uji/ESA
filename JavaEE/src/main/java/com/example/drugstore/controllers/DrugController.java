package com.example.drugstore.controllers;

import com.example.drugstore.entities.Drug;
import com.example.drugstore.services.DrugService;
import com.example.drugstore.services.DrugstoreService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/drugs")
public class DrugController extends HttpServlet {

    @EJB
    private DrugService drugService;

    @EJB
    private DrugstoreService drugstoreService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("drugs", drugService.getAllDrugs());
        request.setAttribute("drugstores", drugstoreService.getAllDrugStores());
        request.getRequestDispatcher("drug.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            Long drugstoreId = Long.parseLong(request.getParameter("drugstore_id"));

            Drug drug = new Drug();
            drug.setTitle(title);
            drug.setDescription(description);
            drug.setDrugstore(drugstoreService.getDrugStoreById(drugstoreId));

            drugService.createDrug(drug);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            drugService.deleteDrug(id);

        }

        doGet(request, response);
    }
}
