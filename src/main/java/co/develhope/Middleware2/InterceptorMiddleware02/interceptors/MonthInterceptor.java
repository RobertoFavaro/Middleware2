package co.develhope.Middleware2.InterceptorMiddleware02.interceptors;

import co.develhope.Middleware2.InterceptorMiddleware02.entities.Month;
import co.develhope.Middleware2.InterceptorMiddleware02.services.MonthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    @Autowired
    private MonthService monthService;
    private List<Month> months = new ArrayList<>();

    public MonthInterceptor() {
        // Populate list of months
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "Maggio"));
        months.add(new Month(4, "April", "Aprile", "Agosto"));
        months.add(new Month(5, "May", "Maggio", "Giugno"));
        months.add(new Month(6, "June", "Giugno", "Luglio"));
    }


    // if monthNumber is null/empty then returns an HTTP Bad Request error
    //else:
    //looks if the passed monthNumber is present in the list
    //if present, returns it using a specific request attribute
    //else, returns an empty Month with all the string values set to nope
    //returns an HTTP OK status

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");
        Integer monthNumberInt = Integer.parseInt(monthNumber);
        Month monthSelected = monthService.findMonthByNumber(monthNumberInt);
        if (monthNumber.equals(null) || monthNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        } else if (months.contains(monthSelected)) {
            request.setAttribute("monthSelected", monthSelected);
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            monthSelected = new Month(0, "nope", "nope", "nope");
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object
            handler, @Nullable Exception ex) throws Exception {
    }


}
