package co.develhope.Middleware2.InterceptorMiddleware02.services;

import co.develhope.Middleware2.InterceptorMiddleware02.entities.Month;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MonthService {
    private ArrayList<Month> months = new ArrayList<>();


    public Month findMonthByNumber(Integer monthNumber) {
        for (Month month : months) {
            if (month.getMonthNumber().equals(monthNumber)) {
                return month;
            }
        }
        return null;
    }
}