package client;
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webServise.IwebServise;
import java.util.Scanner;

public class webServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");
        Scanner scan = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner delete = new Scanner(System.in);
        Scanner freeDate = new Scanner(System.in);
        Scanner deleteDate = new Scanner(System.in);
        QName qname = new QName("http://webServise/", "webServiseFuncService");
        Service service = Service.create(url, qname);
        IwebServise serviseFunc = service.getPort(IwebServise.class);
        String[] menu;
        Integer role;
        menu = serviseFunc.auth();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        while (true) {
            role = serviseFunc.getRole();
                if (role == 1) {
                        Integer n = scan.nextInt();
                    if (n == 1){
                       System.out.println("Название услуги:");
                        String serviceName = in.nextLine();
                        System.out.println("Продолжительность:");
                        String time = in.nextLine();
                        System.out.println("Стоимость:");
                        String sum = in.nextLine();
                        String req = serviseFunc.addServise(serviceName, time, sum);
                        System.out.println(req);
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                    } else if (n == 2){
                        System.out.println("Номер услуги для удаления:");
                        Integer index = delete.nextInt();
                        String req = serviseFunc.deleteServise(index);
                        System.out.println(req);
                        System.out.println("9. Назад");
                        menu = serviseFunc.getMenu(role);
                        for (int i = 0; i < menu.length; i++) {
                            System.out.println(menu[i]);
                        }
                    } else if (n == 3){
                            Object[] services = serviseFunc.getServises();
                            for (int i = 0; i < services.length; i++) {
                                System.out.println(i + ". " + services[i]);
                            }
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                        } else {
                            menu = serviseFunc.authMenu(n);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                        role = serviseFunc.getRole();
                } else if (role == 2) {
                        Integer n = scan.nextInt();
                    if (n == 1){
                        Object[] services = serviseFunc.getServises();
                        for (int i = 0; i < services.length; i++) {
                            System.out.println(i + ". " + services[i]);
                        }
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                    } else if (n == 2){
                        System.out.println("Дата:");
                        String date = freeDate.nextLine();
                        Object[] req = serviseFunc.getFreeTime(date);
                        for (int i = 0; i < req.length; i++) {
                            System.out.println(i + ". " + req[i]);
                        }
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                    } else if (n == 3){
                        System.out.println("Дата:");
                        String date = in.nextLine();
                        System.out.println("Время:");
                        String time = in.nextLine();
                        System.out.println("Услуга:");
                        String id = in.nextLine();
                        String req = serviseFunc.takeTime(date, time, id);
                        System.out.println(req);
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                    } else if (n == 4){
                        System.out.println("Ваш идентификатор для отмены:");
                        Integer id = deleteDate.nextInt();
                        String req = serviseFunc.deleteTime(id);
                        System.out.println(req);
                        System.out.println("9. Назад");
                        n = scan.nextInt();
                        if (n == 9){
                            menu = serviseFunc.getMenu(role);
                            for (int i = 0; i < menu.length; i++) {
                                System.out.println(menu[i]);
                            }
                        }
                    } else {
                        menu = serviseFunc.authMenu(n);
                        for (int i = 0; i < menu.length; i++) {
                            System.out.println(menu[i]);
                        }
                        role = serviseFunc.getRole();
                    }
                } else {
                    role = scan.nextInt();
                    menu = serviseFunc.getMenu(role);
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println(menu[i]);
                    }
                }
            }
        }
    }