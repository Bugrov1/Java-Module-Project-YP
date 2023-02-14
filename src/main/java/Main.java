import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество гостей");
        int guestNum ;


         while (true){
             while (!scanner.hasNextInt()){
                 scanner.next();
                 System.out.println("Введите количетсво гостей числом!!!");

             }
             int guests =scanner.nextInt();
             if (guests>1){
                 System.out.println("Количество гостей = "+guests);
                 guestNum =guests;
                 break;
             }
             if (guests==1){
                 System.out.println("Нет смысла ничего считать и делить.\nВведите корректное количество гостей");
             }
             else {
                 System.out.println("Введите корректное количество гостей");

             }
         }


        while (true){
            System.out.println("Введите название товара  ");
            String good =scanner.next();
            if (good.equalsIgnoreCase("завершить")){
                break;
            }//111
            else{
                System.out.println("Введите цену для  "+good+" в формате \"рубли,копейки\"");

                while (true){
                    while (!scanner.hasNextDouble()){
                        scanner.next();
                        System.out.println("Введите цену в правильном формате!!!");
                    }

                    double price = scanner.nextDouble();
                    if (price<=0){
                        System.out.println("Цена не может быть отрицательной,введите корректную цену");
                    }else{
                        Goods.add(good,price);
                        System.out.println(good+" Успешно добавлен");
                        Goods.check();
                        System.out.println("Хотите добавить еще один товар? Для окончания покупки напечайте \"Завершить\" ");
                        break;
                    }
                }

            }




        }
        Goods.check();
        double payEach =Goods.priceTotal/guestNum;


        System.out.println("Сумма к оплате каждого гостя: "+payEach+" "+Convert.ending(payEach));






        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

    }
}

 class Goods {

     static String goodsList="";
     static Double priceTotal=0.0;


    static void add(String name, double priceName){
        String rubName =Convert.ending(priceName);
        goodsList=goodsList+"\n"+name+" "+"Цена: "+priceName+" "+rubName;
        priceTotal+=priceName;

    }
     static void check(){
        System.out.println("Добавленные товары: "+goodsList);
         System.out.println("ОБщая сумма: "+priceTotal+" "+Convert.ending(priceTotal));
         if (priceTotal ==0&&goodsList.equals("")){System.out.println("Вы не выбрали товар");}//1111
    }


}

class Convert {

    static String ending(double number){

        double numRound = Math.floor(number);
        double leftOver= Math.floor(numRound)%10;
        if(Math.floor(numRound)%100>=11&&Math.floor(numRound)%100<=19){
            return "рублей";
        }
        else{
            if(leftOver==1){
            return "рубль";
            }
            else if (leftOver>=2&&leftOver<=4){
            return "рубля";
            }
            else if (leftOver>=5&&leftOver<=9){
            return "рублей";
            }else{
            return  "рублей";
            }
        }

    }



}