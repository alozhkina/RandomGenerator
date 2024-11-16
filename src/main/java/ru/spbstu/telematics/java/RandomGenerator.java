package ru.spbstu.telematics.java;

/**
 * Hello world!
 *
 */
public class RandomGenerator 
{
    //Испоьзуется линейный конгруэнтный метод
    private long seed;
    private static final long a = 1664525;
    private static final long c = 1013904223;
    private static final long m = (long) Math.pow(2,32);

    public RandomGenerator(long seed){
        this.seed = seed;
    }

    //Метод для генерации следующего псевдослучайного числа
    public int nextValue(){
        seed = (a * seed + c) % m;
        return (int) seed;
    }

    //Метод для генерации псевдослучайного числа в диапазоне от 0 до max
    public int nextValue(int max){
        if (max <= 0){
            throw new IllegalArgumentException("Параметр max должен быть положительным.");
        }
        return Math.abs(nextValue()) % max;
    }

    //Метод для генерации псевдослучайного числа в диапазоне от min до max
    public int nextValue(int min, int max){
        if (min >= max){
            throw new IllegalArgumentException("Параметр min должен быть меньше max.");
        }
        return min + Math.abs(nextValue()) % (max - min);
    }
    public static void main( String[] args )
    {
        RandomGenerator generator = new RandomGenerator(15);
        System.out.println("Слуайное число: " + generator.nextValue());
        System.out.println("Случайное число от 0 до 100: " + generator.nextValue(100));
        System.out.println("Случайное число от 50 до 150: " + generator.nextValue(50, 150));

        try{
            System.out.println(generator.nextValue(5,5));
        }
        catch (IllegalArgumentException e){
            System.out.println("Ошибка: " + e.getMessage());
        }

        try{
            System.out.println(generator.nextValue(-7));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
        
}
