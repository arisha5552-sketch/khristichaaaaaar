import java.util.Arrays; //подключаем класс Arrays, в котором есть метод sort

public class Solution {
    //принимает массив чисел и возвращает true, если есть дубликаты
    public boolean containsDuplicate(int[] nums) {
        
        //если массив null или пустой — дубликатов точно нет
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        //сортируем массив,это займет O(n log n)
        Arrays.sort(nums);
        
        //сравниваем соседние элементы
        //идем до nums.length - 1, потому что сравниваем i и i+1
        for (int i = 0; i < nums.length - 1; i++) {
            
            // если текущий элемент равен следующему — нашли дубликат
            if (nums[i] == nums[i + 1]) {
                return true; // сразу true
            }
        }
        
        //если прошли весь цикл и не нашли — дубликатов нет
        return false;
    }
}