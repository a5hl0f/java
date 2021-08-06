package com.company;

import java.util.Scanner;

public class Controller {
  private Scanner scanner;
  private Storage localStorage;
  private boolean online;

    public Controller() {
        localStorage=new Storage();
        scanner=new Scanner(System.in);
        online=true;
    }

    public void start() {
        boolean stay=true;
        int choice;
        do{
            System.out.println("menu: 1- enter position / 2-list localStorage/ 3 delete from local storage /4 connection state /5-set connection state / 6 -exit");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:createPosition(scanner);break;
                case 2:lisLocalStorage();break;
                case 3:deletelocalstorage(scanner);break;
                case 4:readconnection(); break;
                case 5:setConnection(scanner);break;

                case 6:stay=false;break;
            }
        }
            while (stay);



    }

    private void deletelocalstorage(Scanner scanner) {
        System.out.println("how many position you would like  to delete ");
        int choice=scanner.nextInt();
        scanner.nextLine();
        localStorage.multiple(choice);
    }

    private void setConnection(Scanner scanner) {
        System.out.println("set connection :(online / offline");
        String choice=scanner.nextLine();
        if(choice.equals("online")){
            online=true;
            System.out.println("connection is online");
            System.out.println("syn");
            lisLocalStorage();
            localStorage.clear();
        }else {
            online=false;
            System.out.println("connection is offline");
        }
    }

    private void readconnection() {
        if(online){
            System.out.println("connection is online ");
        }else {
            System.out.println("connection is offline");
        }
    }

    private void lisLocalStorage() {
        if(localStorage.size()==0){
            System.out.println("localStorage IS EMPTY");
        }else {
            for(int i=0;i<localStorage.size();i++){
                System.out.println(localStorage.get(i));
            }
        }
    }

    private void createPosition(Scanner scanner){
        System.out.println("hey, please enter the position ");
        System.out.print("x: ");
        int x=scanner.nextInt();
        scanner.nextLine();
        System.out.print("y: ");
        int y=scanner.nextInt();
        scanner.nextLine();
        System.out.print("z:  ");
        int z=scanner.nextInt();
        scanner.nextLine();

        Position newPosition=new Position(x,y,z);
//        System.out.println(newPosition);
        if(online){
            System.out.println(newPosition);
        }else {
            localStorage.add(newPosition);
            System.out.format("connection is offline, %d data in local ",localStorage.size());
            System.out.println();
        }
     }
}
