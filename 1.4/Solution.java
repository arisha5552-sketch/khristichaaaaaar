import java.util.ArrayList;
import java.util.List;

//создаем класс, который описывает одного студента
class Student {
    String name;   //ФИО
    int grade;     //оценка
    int group;     //номер группы

    //чтобы удобно создавать студентов
    public Student(String name, int grade, int group) {
        this.name = name;
        this.grade = grade;
        this.group = group;
    }

    //метод для красивого вывода
    @Override
    public String toString() {
        return "Группа: " + group + ", Оценка: " + grade + ", ФИО: " + name;
    }
}


public class Solution {

    //метод сортировки списка студентов
    public void sortStudents(List<Student> students) {
        
        //вызываем метод sort у списка и передаем ему лямбда-выражение (компаратор)
        students.sort((s1, s2) -> {
            
            //сначала сортируем по группе (по возрастанию)
            //если группы разные, возвращаем результат их сравнения
            if (s1.group != s2.group) {
                return Integer.compare(s1.group, s2.group);
            }

            //если группы одинаковые, сортируем по оценке (ПО УБЫВАНИЮ)
            //s2 и s1 поменяны местами, чтобы было от большего к меньшему
            if (s1.grade != s2.grade) {
                return Integer.compare(s2.grade, s1.grade);
            }

            //если и группы, и оценки одинаковые, сортируем по ФИО (по алфавиту)
            //метод compareTo() сравнивает строки: "Аня" < "Борис"
            return s1.name.compareTo(s2.name);
        });
    }

    //проверка
    public static void main(String[] args) {
        // Создаем список студентов (имитация таблицы)
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 4, 101));
        students.add(new Student("Петров", 5, 101));
        students.add(new Student("Сидоров", 5, 102));
        students.add(new Student("Алексеев", 4, 101));
        students.add(new Student("Борисов", 5, 101));

        //создаем объект нашего класса и вызываем сортировку
        Solution solver = new Solution();
        solver.sortStudents(students);

        //выводим отсортированный список на экран
        System.out.println("Результат сортировки:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
//сортировка должна обладать свойством устойчивости(два элемента, равные по ключу сортировки, 
//сохраняют свой относительный порядок, т.е. если два студента имеют одинаковую оценку, 
//то их порядок по алфавиту не нарушится.)
//если использовать неустойчивый алгоритм, то при сортировке по группе или оценке может сломаться порядок
// сортировки по другим признакам, который был установлен ранее.
