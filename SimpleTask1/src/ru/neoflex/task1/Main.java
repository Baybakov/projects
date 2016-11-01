package ru.neoflex.task1;

//объявление класса, программа на Java состоит из классов
public class Main {

	/*
	 * Объявили два поля в нашем классе с типом int, модификатор private говорит
	 * о том что поля не доступны вне класса
	 */
	private int begin;
	private int end;

	/*
	 * объявили конструктор, для того что бы создать экземпляр класcа смысл кода
	 * конструктора будет понятен после следующих лекций конструктор создаст
	 * класс и присвоит полям begin и end значения которые переданы в параметрах
	 * конструктора
	 * 
	 */
	public Main(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	/*
	 * Метод класса, методы определяют поведение класса. Метод
	 * getSumAllEvenPositive должен вывести на экран все четные положительные
	 * числа в диапазоне (begin; end]. begin не входит в диапазон, end входит
	 * Шаг задается параметром step, 
	 * переменная addWithoutConditions определяет число 
	 * из диапазона, которое учитывается всегда (не зависимо от знака и четности) 
	 * Если addWithoutConditions не входит в диапазон оно не учитывается
	 * Метод должен вернуть сумму чисел выводимых на экран
	 * 
	 * Что использовать for (while), if, System.out.println()
	 */
	public int getSumAllEvenPositive(int step, int addWithoutConditions) {
		int sum = 0;
        if(addWithoutConditions > begin && addWithoutConditions <= end){
            sum += addWithoutConditions;
            System.out.println(addWithoutConditions);
        }
		for(int i = begin + step; i <= end; i += step){
            if(i % 2 == 0 && i > 0 && i != addWithoutConditions){
                sum += i;
                System.out.println(i);
            }
        }
		return sum;
	}

	/*
	 * метод определяющий точку фхода программы, модификатор static говорит о
	 * том, что к метод принаждежит классу, а не к экземпляру класса.
	 */
	public static void main(String[] args) {
		//создадим экземпляр класса Main
		Main main = new Main(-100,1000);
		
		//вызовем релизованный метод 
	    int sum = main.getSumAllEvenPositive(2,-6);
	    //выводим результат на экран
	    System.out.println("Cумма: " + sum);
	    //проверка
		if (sum == 250494){
	    	System.out.println("Ok:)");
	    } else {
	    	System.out.println("Error:(");
	    }
	}

}
