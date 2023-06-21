/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Perfil;
import model.dao.PerfilDAO;

/**
 *
 * @author ybiel
 */
@WebServlet(name = "GerenciarLogin", urlPatterns = {"/gerenciar_login.do"})
public class GerenciarLogin extends HttpServlet {

    private static HttpServletResponse response;
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GerenciarLogin.response = response;
        String login_per = request.getParameter("login_per");
        String senha_per = request.getParameter("senha_per");
        ArrayList<String> erros = new ArrayList<String>();
        if(login_per==null || login_per.trim().isEmpty()) {
            erros.add("Preencha o login!");
        }
        if(senha_per==null || senha_per.trim().isEmpty()) {
            erros.add("Preencha a senha!");
        }
        
        if(erros.size()>0) {
            String campos = "";
            for(String erro: erros) {
                campos = campos + "\\n"+erro;
            }
            exibirMensagem("Preencha o(s) campo(s): "+campos);
        } else {
            try {
                PerfilDAO pDAO = new PerfilDAO();
                Perfil p = new Perfil();
                p = pDAO.getRecuperarPerfil(login_per);
                if(p.getIdPerfil()>0 || p.getSenha_per().equals(senha_per)) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("plogado", p);
                    response.sendRedirect("index.jsp");
                } else {
                    exibirMensagem("Login ou senha inválidos!");
                }
            } catch(Exception e) {
                exibirMensagem("Perfil não encontrado!");
            }
        }
        
    }
    
    private static void exibirMensagem(String mensagem) {
        
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("<alert('"+mensagem+"'>");
            out.print("history.back();");
            out.print("</script>");
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static Perfil verificarAcesso(HttpServletRequest request, HttpServletResponse response) {
        
        Perfil p = null;
        GerenciarLogin.response = response;
        try {
            HttpSession sessao = request.getSession();
            if(sessao.getAttribute("plogado")==null) {
                response.sendRedirect("form_login.jsp");
            } else  {
                String uri = request.getRequestURI();
                String queryString = request.getQueryString();
                if(queryString!=null) {
                    uri += "?" +queryString;
                }
                p = (Perfil) request.getSession().getAttribute("plogado");
                if(p==null) {
                    sessao.setAttribute("mensagem", "Você não está autenticado!");
                    response.sendRedirect("form_login.jsp");
                } else {
                    boolean possuiAcesso=false;
                    for(menu m)
                }
            }
        } catch(Exception e) {
            exibirMensagem("Exceção:"+e.getMessage());
        }
        return p;
        
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
