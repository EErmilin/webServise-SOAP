package webServise;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "webServise.IwebServise")
public class webServiseFunc implements IwebServise {
    Integer roleData = 0;
    Integer users = 0;
    ArrayList<String> servises  = new ArrayList<String>();
    ArrayList<String> date  = new ArrayList<String>();
    @Override
    public String[] auth() {
        servises.add(" Услуга 1 Время: 30  Сумма: 1000 " );
        servises.add(" Услуга 2 Время: 45  Сумма: 1000 " );
        String[] menu = {"1. Admin", "2. Client"};
        return menu;
    }
    public Integer getRole() {
        return roleData;
    }
    public Object[] getServises() {
        return servises.toArray();
    }
    public String[] getMenu(Integer role) {
        roleData = role;
        if (role == 1) {
            String[] menuAdmin = {"1. Добавить услугу", "2. Удалить услугу", "3. Список услуг", "0. Выйти"};
             return menuAdmin;
        } else {
            String[] menuClient = {"1. Список услуг", "2. Свободное время мастера", "3. Записаться", "4. Отказаться", "0. Выйти"};
            return menuClient;
        }
    }
    public String[] authMenu(Integer N) {
            roleData = 0;
            String[] menuAunt = {"1. Admin", "2. Client"};
            return menuAunt;
    }
    public String addServise(String name, String time, String sum) {
        servises.add(name + " Время: " + time + " Сумма: " + sum );
        return "Услуга добавлена.";
    }
    public String deleteServise(Integer i) {
        servises.remove(servises.get(i));
        return "Услуга удалена.";
    }
    public Object[] getFreeTime(String selectDate) {
        ArrayList<String> FreeDate  = new ArrayList<String>();
        for (int time = 9; time < 14; time++) {
            int isFree = date.indexOf(selectDate + " " + time + ":00");
            if (isFree == -1) {
                FreeDate.add(selectDate + " " + time + ":00");
            }
        }
        return FreeDate.toArray();
    }
    public String takeTime(String selectDate, String time, String I) {
        int isFree = date.indexOf(selectDate + " " + time);
        if (isFree == -1) {
            users += 1;
            date.add(selectDate + " " + time);
            return "Запись выполнена. Ваш идентификатор: " + users;
        } else {
            return "Время занято.";
        }
    }
    public String deleteTime(Integer I) {
        users -= 1;
        date.remove(date.get(I-1));
        return "Запись отменена.";
    }
}
