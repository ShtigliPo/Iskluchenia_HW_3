package ru.gb;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, 
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. 
 * Если в каком-то элементе массива преобразование не удалось 
 * (например, в ячейке лежит символ или текст вместо числа), 
 * должно быть брошено исключение MyArrayDataException, 
 * с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, 
 * обработать возможные исключения MyArraySizeException и MyArrayDataException 
 * и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
 */
public class App 
{
    
    private static final String errorSizeArray = "Неверный размер! Размер должен быть 4х4! ";
    private static final String errorDataElement = "Преобразование в int невозможно! Это не число! ";
    private static final String sumElementArray = "Сумма элементов массива равна ";
    
    
    public static void main( String[] args )
    {
        String[][] array1 = {
            { "6", "15", "11", "24" },
            { "22", "16", "1", "5" },
            { "32", "17", "2", "6" },
            { "14", "12", "3", "7" },
        };
        String[][] array2 = {
            { "4", "6", "8", "10" },
            { "32", "21", "17", "err" },
            { "1", "7", "8", "2" },
            { "11", "12", "4", "5" },
        };
        String[][] array3 = {
            { "6", "15", "11", "24", "16" },
            { "22", "16", "1", "5", "17" },
            { "32", "17", "2", "6", "8" },
            { "14", "12", "3", "7", "5" },
        };

        try {
            System.out.println(sumStr(array1));
        } catch (MyArrayExceptions e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumStr(array2));
        } catch (MyArrayExceptions e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumStr(array3));
        } catch (MyArrayExceptions e) {
            e.printStackTrace();
        }
    }

    private static void checkSize(String[][] arr) throws MyArraySizeException {

        if (arr.length != 4) {
            throw new MyArraySizeException(errorSizeArray);
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new MyArraySizeException(errorSizeArray);
            }
        }
    }

    private static void checkInt(String[][] arr) throws MyArrayDataException {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(errorDataElement + "Ошибка в элементе с индексом [" + i + "][" + j + "].");
                }
            }
        }
    }

    private static int sumInt(String[][] arr) {

        int result = 0;
        for (String[] str : arr) {
            for (String string : str) {
                result += Integer.parseInt(string);
            }
        }
        return result;
    }

    private static String sumStr(String[][] arr) throws MyArrayExceptions {
        checkSize(arr);
        checkInt(arr);
        return sumElementArray + sumInt(arr);
    }
}
        
    

