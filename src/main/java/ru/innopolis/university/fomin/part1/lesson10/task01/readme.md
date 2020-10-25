# ДЗ_10
Дан интерфейс

~~~
public interface Worker {
    void doWork();
}
~~~

Необходимо написать программу, выполняющую следующее:

Программа с консоли построчно считывает код метода doWork. Код не должен требовать импорта дополнительных классов.
После ввода пустой строки считывание прекращается и считанные строки добавляются в тело метода public void doWork() в файле SomeClass.java.
Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
Полученный файл подгружается в программу с помощью кастомного загрузчика
Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
Общие критерии оценки:

**Программа компилируется.**
* В ходе работы программе не возникает ошибок в процессе выполнения, за исключением, где это необходимо.
* Программа в результате своей работы возвращает корректный результат, т.е. тот который требуется по условиям задания.
* Выполнены все архитектурные принципы построения программы, правильно применены принципы ООП.
* Присутствует документация (JavaDoc).
* Код соответствует принципам Java Code Convention.
* Работа с ресурсами (файлы, потоки и т.д.) осуществляется корректно.
* В программе предусмотрено возникновение исключительных ситуаций.
* Код программы, без лишних локальных файлов, должен быть загружен в открытый репозиторий (github, bitbucket, gitlab).
* Решение задачи оформляется в пакете с номером задания, например part1.lesson01.task01. В системе Moodle размещается ссылка на пакет с решением в репозитории. Рекомендуется придерживаться версионности, каждая новая ветка – является решением отдельного задания.