public class Solution {
    //принимает массив чисел и число, которое надо удалить
    public int removeElementInPlace(int[] nums, int val) {
        
        if (nums == null) {
            return 0;
        }

        if (nums.length > 100) {
            return 0;
        }
        
        if (val < 0 || val > 100) {
            return 0;
        }
        
        for (int num : nums) {
            if (num < 0 || num > 50) {
                return 0;
            }
        }
        //показывает, куда класть следующий хороший элемент
        int slow = 0; 
        // бежит по всему массиву и ищет хорошие элементы
        for (int fast = 0; fast < nums.length; fast++) {
            
            //если текущий элемент НЕ равен тому, что мы удаляем
            if (nums[fast] != val) {
                // перезаписываем элемент на позицию slow
                nums[slow] = nums[fast];
                //сдвигаем slow на следующую позицию
                slow++;
            }
        }
        //в конце slow равен количеству оставшихся элементов, возвращаем его
        return slow; 
    }
}