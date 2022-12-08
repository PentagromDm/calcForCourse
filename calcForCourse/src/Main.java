import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Приветствую! Я калькулятор идиот, я понимаю только числа от 1 до 10 и аналогичные римские.\nКогда вводите выражение - используйте латинские буквы x, v, i и арабские цифры.\nНе забывайте ставить между операндами и оператором пробелы, иначе я нихрена не пойму.\nТакже я не умею вычислять разные по типу операнды, или только арабские, или только римские.\nА теперь, введите выражение: ");
        try {
            Scanner cal = new Scanner(System.in);
            String task = calc(cal.nextLine());
            System.out.println("Результат операции: " + task);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Необходимо ставить пробел между операндами и оператором");
        } catch (NumberFormatException e){
            System.out.println("При вводе используйте только числа и латинские буквы: x, v или i, а также оператор между ними");
        }
    }
    public static String calc(String input) {
        String[] expression = input.split(" "); //разделил строку по элементам
        String El1 = expression[0];
        String El2 = expression[2];
        String act = expression[1];
        String[] nums = {El1.toUpperCase(), El2.toUpperCase()};
        String res=null;
        if(expression.length>3){
            System.out.println("Введите два числа и операнд!");
        } else{
            if (nums[0].contains("X") || nums[1].contains("X") || nums[0].contains("V") || nums[1].contains("V") || nums[0].contains("I") || nums[1].contains("I")) {
                res=rome(nums[0],nums[1], act)+"";

            } else {
                res=arab(nums[0],nums[1], act)+"";
            }
        }
        return res;
    }
    public static int arab(String a1, String a2, String act){
        int num1=Integer.parseInt(a1);
        int num2=Integer.parseInt(a2);
        int a=0;
        if(num1>10||num2>10||num1<1||num2<1) {
            System.out.println("Повторите ввод значений согласно правилам");
        } else {
            switch (act) {
                case "+" -> a = num1 + num2;
                case "-" -> a = num1 - num2;
                case "*" -> a = num1 * num2;
                case "/" -> a = num1 / num2;
                default -> {
                    System.out.println("Вы ввели недопустимое действие");
                }
            }
        }
        return a;
    }
    public static String rome(String r1, String r2, String act){
        String[] exp=new String[2];
        String[] roman= new String[]{r1, r2};
        for(int i=0; i<roman.length; i++) {
            switch (roman[i]) {
                case "I":
                    exp[i]="1";
                    break;
                case "II":
                    exp[i]="2";
                    break;
                case "III":
                    exp[i]="3";
                    break;
                case "IV":
                    exp[i]="4";
                    break;
                case "V":
                    exp[i]="5";
                    break;
                case "VI":
                    exp[i]="6";
                    break;
                case "VII":
                    exp[i]="7";
                    break;
                case "VIII":
                    exp[i]="8";
                    break;
                case "IX":
                    exp[i]="9";
                    break;
                case "X":
                    exp[i]="10";
                    break;
                default:
                    exp[i]="-1000";
            }
        }
        int wait=arab(exp[0], exp[1], act);
        return romaToArab(wait);
    }
    public static String romaToArab(int integ){
        String res="";
        int bufer=integ;
        if(bufer>0) {
            while (bufer >= 100) {
                res += "C";
                bufer -= 100;
            }
            while (bufer >= 90) {
                res += "XC";
                bufer -= 90;
            }
            while (bufer >= 50) {
                res += "L";
                bufer -= 50;
            }
            while (bufer >= 40) {
                res += "XL";
                bufer -= 40;
            }
            while (bufer >= 10) {
                res += "X";
                bufer -= 10;
            }
            while (bufer >= 9) {
                res += "IX";
                bufer -= 9;
            }
            while (bufer >= 5) {
                res += "V";
                bufer -= 5;
            }
            while (bufer >= 4) {
                res += "IV";
                bufer -= 4;
            }
            while (bufer >= 1) {
                res += "I";
                bufer -= 1;
            }
        } else{
            res="неудача";
        }
        return res;
    }

}
