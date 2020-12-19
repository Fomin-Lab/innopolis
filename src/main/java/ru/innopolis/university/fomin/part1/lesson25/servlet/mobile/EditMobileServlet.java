package ru.innopolis.university.fomin.part1.lesson25.servlet.mobile;

import ru.innopolis.university.fomin.part1.lesson25.controllers.MobileController;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Edit mobile servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/mobile-edit")
public class EditMobileServlet extends HttpServlet {
    /**
     * Controller
     */
    @Inject
    private MobileController mobileController;

    /**
     * Send form
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null) {
            resp.setStatus(404);
            req.setAttribute("PageBody", "jsp/not-found.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        } else {
            MobileModel mobile = mobileController.getEntityById(Integer.parseInt(id));
            req.setAttribute("mobile", mobile);
            req.setAttribute("PageTitle", "Mobile edit");
            req.setAttribute("PageBody", "forms/mobile-form.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }

    /**
     * Update mobile model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        MobileModel mobile = new MobileModel(
                req.getParameter("type_of_os"),
                req.getParameter("model")
        );

        mobile.setId(Integer.parseInt(req.getParameter("id")));
        mobileController.update(mobile);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
