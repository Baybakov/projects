package ru.neoflex.advanced.task1;

//класс представляющий простую дробь
public class Ratio {
	// числитель
	private int numer;

	// знаменатель
	private int denom;

	public Ratio(int numer, int denom) {
        if((numer < 0 && denom < 0) || (numer > 0 && denom < 0)){
            numer *= -1;
            denom *= -1;
        }
		this.numer = numer;
		this.denom = denom;
		reduction();
	}

	public Ratio(double ratio) {
		this.numer = 0;
        this.denom = 1;
        int number = 0;
        boolean ok = false;
        String s = Double.toString(ratio);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '-'){
                continue;
            }
            if(s.charAt(i) == '.'){
                ok = true;
                continue;
            }
            if(!ok){
                number = number * 10 + s.charAt(i) - '0';
            }
            else{
                this.numer = this.numer * 10 + s.charAt(i) - '0';
                this.denom *= 10;
            }
        }
        this.add(number);
        reduction();
        if(ratio < 0) this.numer *= -1;
	}

	// сокращение дроби, для нахождения НОД использовать
	// алгоритм Евклида
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

	private void reduction() {
		int nod = gcd(Math.abs(this.numer), Math.abs(this.denom));
        if(nod == 0) nod++;
        this.numer /= nod;
        this.denom /= nod;
	}

	// сложение с целым
	public Ratio add(int number) {
        this.numer += number * this.denom;
		reduction();
		return this;
	}

	// сложение с дробью
	public Ratio add(Ratio ratio) {
        this.numer = this.numer * ratio.denom + this.denom * ratio.numer;
        this.denom = this.denom * ratio.denom;
		reduction();
		return this;
	}

	// вычитание целого
	public Ratio substract(int number) {
        this.numer -= number * this.denom;
		reduction();
		return this;
	}

	// вычитание дроби
	public Ratio substract(Ratio ratio) {
        this.numer = this.numer * ratio.denom - this.denom * ratio.numer;
        this.denom = this.denom * ratio.denom;
		reduction();
		return this;
	}

	// умножение на целое
	public Ratio multiply(int number) {
        this.numer = number * this.numer;
		reduction();
		return this;
	}

	// умножение дроби
	public Ratio multiply(Ratio ratio) {
        this.numer = this.numer * ratio.numer;
        this.denom = this.denom * ratio.denom;
		reduction();
		return this;
	}

	// деление на число
	public Ratio devide(int number) {
        this.denom = this.denom * number;
		reduction();
		return this;
	}

	// деление на дробь
	public Ratio devide(Ratio ratio) {
        this.numer = this.numer * ratio.denom;
        this.denom = this.denom * ratio.numer;
		reduction();
		return this;
	}

	// строковое представление
	public String toString() {
		return numer + "/" + denom;
	}

}
