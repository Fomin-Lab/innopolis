package ru.innopolis.university.fomin.part1.lesson07.task02.dictionaries;

import java.util.ArrayList;
import java.util.List;

/**
 * Class container for words and chars
 */
public class Dictionary {
    /**
     * Latin alphabet
     */
    public final static char[] LATIN_LETTERS = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'
    };

    /**
     * Char end of sentence
     */
    public final static char[] CHARS_END_SENTENCE = new char[] {
        '?', '!', '.'
    };

    /**
     * 1000 different russian words
     */
    public final static List<String> WORDS = new ArrayList<String>() {{
        add("и");
        add("в");
        add("не");
        add("он");
        add("на");
        add("я");
        add("что");
        add("тот");
        add("быть");
        add("с");
        add("а");
        add("весь");
        add("это");
        add("как");
        add("она");
        add("по");
        add("но");
        add("они");
        add("к");
        add("у");
        add("ты");
        add("из");
        add("мы");
        add("за");
        add("вы");
        add("так");
        add("же");
        add("от");
        add("сказать");
        add("этот");
        add("который");
        add("мочь");
        add("человек");
        add("о");
        add("один");
        add("еще");
        add("бы");
        add("такой");
        add("только");
        add("себя");
        add("свое");
        add("какой");
        add("когда");
        add("уже");
        add("для");
        add("вот");
        add("кто");
        add("да");
        add("говорить");
        add("год");
        add("знать");
        add("мой");
        add("до");
        add("или");
        add("если");
        add("время");
        add("рука");
        add("нет");
        add("самый");
        add("ни");
        add("стать");
        add("большой");
        add("даже");
        add("другой");
        add("наш");
        add("свой");
        add("ну");
        add("под");
        add("где");
        add("дело");
        add("есть");
        add("сам");
        add("раз");
        add("чтобы");
        add("два");
        add("там");
        add("чем");
        add("глаз");
        add("жизнь");
        add("первый");
        add("день");
        add("тута");
        add("во");
        add("ничто");
        add("потом");
        add("очень");
        add("со");
        add("хотеть");
        add("ли");
        add("при");
        add("голова");
        add("надо");
        add("без");
        add("видеть");
        add("идти");
        add("теперь");
        add("тоже");
        add("стоять");
        add("друг");
        add("дом");
        add("сейчас");
        add("можно");
        add("после");
        add("слово");
        add("здесь");
        add("думать");
        add("место");
        add("спросить");
        add("через");
        add("лицо");
        add("что");
        add("тогда");
        add("ведь");
        add("хороший");
        add("каждый");
        add("новый");
        add("жить");
        add("должный");
        add("смотреть");
        add("почему");
        add("потому");
        add("сторона");
        add("просто");
        add("нога");
        add("сидеть");
        add("понять");
        add("иметь");
        add("конечный");
        add("делать");
        add("вдруг");
        add("над");
        add("взять");
        add("никто");
        add("сделать");
        add("дверь");
        add("перед");
        add("нужный");
        add("понимать");
        add("казаться");
        add("работа");
        add("три");
        add("ваш");
        add("уж");
        add("земля");
        add("конец");
        add("несколько");
        add("час");
        add("голос");
        add("город");
        add("последний");
        add("пока");
        add("хорошо");
        add("давать");
        add("вода");
        add("более");
        add("хотя");
        add("всегда");
        add("второй");
        add("куда");
        add("пойти");
        add("стол");
        add("ребенок");
        add("увидеть");
        add("сила");
        add("отец");
        add("женщина");
        add("машина");
        add("случай");
        add("ночь");
        add("сразу");
        add("мир");
        add("совсем");
        add("остаться");
        add("об");
        add("вид");
        add("выйти");
        add("дать");
        add("работать");
        add("любить");
        add("старый");
        add("почти");
        add("ряд");
        add("оказаться");
        add("начало");
        add("твой");
        add("вопрос");
        add("много");
        add("война");
        add("снова");
        add("ответить");
        add("между");
        add("подумать");
        add("опять");
        add("белый");
        add("деньги");
        add("значить");
        add("про");
        add("лишь");
        add("минута");
        add("жена");
        add("посмотреть");
        add("правда");
        add("главный");
        add("страна");
        add("свет");
        add("ждать");
        add("мать");
        add("будто");
        add("никогда");
        add("товарищ");
        add("дорога");
        add("однако");
        add("лежать");
        add("именно");
        add("окно");
        add("никакой");
        add("найти");
        add("писать");
        add("комната");
        add("москва");
        add("часть");
        add("вообще");
        add("книга");
        add("маленький");
        add("улица");
        add("решить");
        add("далекий");
        add("душа");
        add("чуть");
        add("вернуться");
        add("утро");
        add("некоторый");
        add("считать");
        add("сколько");
        add("помнить");
        add("вечер");
        add("пол");
        add("таки");
        add("получить");
        add("народ");
        add("плечо");
        add("хоть");
        add("сегодня");
        add("бог");
        add("вместе");
        add("взгляд");
        add("ходить");
        add("зачем");
        add("советский");
        add("русский");
        add("бывать");
        add("полный");
        add("прийти");
        add("палец");
        add("россия");
        add("любой");
        add("история");
        add("наконец");
        add("мысль");
        add("узнать");
        add("назад");
        add("общий");
        add("заметить");
        add("словно");
        add("прошлый");
        add("уйти");
        add("известный");
        add("давно");
        add("слышать");
        add("слушать");
        add("бояться");
        add("сын");
        add("нельзя");
        add("прямо");
        add("долго");
        add("быстро");
        add("лес");
        add("похожий");
        add("пора");
        add("пять");
        add("глядеть");
        add("оно");
        add("сесть");
        add("имя");
        add("ж");
        add("разговор");
        add("тело");
        add("молодой");
        add("стена");
        add("красный");
        add("читать");
        add("право");
        add("старик");
        add("ранний");
        add("хотеться");
        add("мама");
        add("оставаться");
        add("высокий");
        add("путь");
        add("поэтому");
        add("совершенно");
        add("кроме");
        add("тысяча");
        add("месяц");
        add("брать");
        add("написать");
        add("целый");
        add("огромный");
        add("начинать");
        add("спина");
        add("настоящий");
        add("пусть");
        add("язык");
        add("точно");
        add("среди");
        add("чувствовать");
        add("сердце");
        add("вести");
        add("иногда");
        add("мальчик");
        add("успеть");
        add("небо");
        add("живой");
        add("смерть");
        add("продолжать");
        add("девушка");
        add("образ");
        add("ко");
        add("забыть");
        add("вокруг");
        add("письмо");
        add("власть");
        add("черный");
        add("пройти");
        add("появиться");
        add("воздух");
        add("разный");
        add("выходить");
        add("просить");
        add("брат");
        add("собственный");
        add("отношение");
        add("затем");
        add("пытаться");
        add("показать");
        add("вспомнить");
        add("система");
        add("четыре");
        add("квартира");
        add("держать");
        add("также");
        add("любовь");
        add("солдат");
        add("откуда");
        add("чтоб");
        add("называть");
        add("третий");
        add("хозяин");
        add("вроде");
        add("уходить");
        add("подойти");
        add("поднять");
        add("особенно");
        add("спрашивать");
        add("начальник");
        add("оба");
        add("бросить");
        add("школа");
        add("парень");
        add("кровь");
        add("двадцать");
        add("солнце");
        add("неделя");
        add("послать");
        add("находиться");
        add("ребята");
        add("поставить");
        add("встать");
        add("например");
        add("шаг");
        add("мужчина");
        add("равно");
        add("нос");
        add("мало");
        add("внимание");
        add("капитан");
        add("ухо");
        add("туда");
        add("сюда");
        add("играть");
        add("следовать");
        add("рассказать");
        add("великий");
        add("действительно");
        add("слишком");
        add("тяжелый");
        add("спать");
        add("оставить");
        add("войти");
        add("длинный");
        add("чувство");
        add("молчать");
        add("рассказывать");
        add("отвечать");
        add("становиться");
        add("остановиться");
        add("берег");
        add("семья");
        add("искать");
        add("генерал");
        add("момент");
        add("десять");
        add("начать");
        add("следующий");
        add("личный");
        add("труд");
        add("верить");
        add("группа");
        add("немного");
        add("впрочем");
        add("видно");
        add("являться");
        add("муж");
        add("разве");
        add("движение");
        add("порядок");
        add("ответ");
        add("тихо");
        add("знакомый");
        add("газета");
        add("помощь");
        add("сильный");
        add("скорый");
        add("собака");
        add("дерево");
        add("снег");
        add("сон");
        add("смысл");
        add("смочь");
        add("против");
        add("бежать");
        add("двор");
        add("форма");
        add("простой");
        add("приехать");
        add("иной");
        add("кричать");
        add("возможность");
        add("общество");
        add("зеленый");
        add("грудь");
        add("угол");
        add("открыть");
        add("происходить");
        add("ладно");
        add("черный");
        add("век");
        add("карман");
        add("ехать");
        add("немец");
        add("наверное");
        add("губа");
        add("дядя");
        add("приходить");
        add("часто");
        add("домой");
        add("огонь");
        add("писатель");
        add("армия");
        add("состояние");
        add("зуб");
        add("очередь");
        add("кой");
        add("подняться");
        add("камень");
        add("гость");
        add("показаться");
        add("ветер");
        add("собираться");
        add("попасть");
        add("принять");
        add("сначала");
        add("либо");
        add("поехать");
        add("услышать");
        add("уметь");
        add("случиться");
        add("странный");
        add("единственный");
        add("рота");
        add("закон");
        add("короткий");
        add("море");
        add("добрый");
        add("темный");
        add("гора");
        add("врач");
        add("край");
        add("стараться");
        add("лучший");
        add("река");
        add("военный");
        add("мера");
        add("страшный");
        add("вполне");
        add("звать");
        add("произойти");
        add("вперед");
        add("медленно");
        add("возле");
        add("никак");
        add("заниматься");
        add("действие");
        add("довольно");
        add("вещь");
        add("необходимый");
        add("ход");
        add("боль");
        add("судьба");
        add("причина");
        add("положить");
        add("едва");
        add("черта");
        add("девочка");
        add("легкий");
        add("волос");
        add("купить");
        add("номер");
        add("основной");
        add("широкий");
        add("умереть");
        add("далеко");
        add("плохо");
        add("глава");
        add("красивый");
        add("серый");
        add("пить");
        add("командир");
        add("обычно");
        add("партия");
        add("проблема");
        add("страх");
        add("проходить");
        add("ясно");
        add("снять");
        add("бумага");
        add("герой");
        add("пара");
        add("государство");
        add("деревня");
        add("речь");
        add("начаться");
        add("средство");
        add("положение");
        add("связь");
        add("скоро");
        add("небольшой");
        add("представлять");
        add("завтра");
        add("объяснить");
        add("пустой");
        add("произнести");
        add("человеческий");
        add("нравиться");
        add("однажды");
        add("мимо");
        add("иначе");
        add("существовать");
        add("класс");
        add("удаться");
        add("толстый");
        add("цель");
        add("сквозь");
        add("прийтись");
        add("чистый");
        add("знать");
        add("прежний");
        add("профессор");
        add("господин");
        add("счастье");
        add("худой");
        add("дух");
        add("план");
        add("чужой");
        add("зал");
        add("представить");
        add("особый");
        add("директор");
        add("бывший");
        add("память");
        add("близкий");
        add("сей");
        add("результат");
        add("больной");
        add("данный");
        add("кстати");
        add("назвать");
        add("след");
        add("улыбаться");
        add("бутылка");
        add("трудно");
        add("условие");
        add("прежде");
        add("ум");
        add("улыбнуться");
        add("процесс");
        add("картина");
        add("вместо");
        add("старший");
        add("легко");
        add("центр");
        add("подобный");
        add("возможно");
        add("около");
        add("смеяться");
        add("сто");
        add("будущее");
        add("хватать");
        add("число");
        add("всякое");
        add("рубль");
        add("почувствовать");
        add("принести");
        add("вера");
        add("вовсе");
        add("удар");
        add("телефон");
        add("колено");
        add("согласиться");
        add("мало");
        add("коридор");
        add("мужик");
        add("правый");
        add("автор");
        add("холодный");
        add("хватить");
        add("многие");
        add("встреча");
        add("кабинет");
        add("документ");
        add("самолет");
        add("вниз");
        add("принимать");
        add("игра");
        add("рассказ");
        add("хлеб");
        add("развитие");
        add("убить");
        add("родной");
        add("открытый");
        add("менее");
        add("предложить");
        add("желтый");
        add("приходиться");
        add("выпить");
        add("крикнуть");
        add("трубка");
        add("враг");
        add("показывать");
        add("двое");
        add("доктор");
        add("ладонь");
        add("вызвать");
        add("спокойно");
        add("попросить");
        add("наука");
        add("лейтенант");
        add("служба");
        add("оказываться");
        add("привести");
        add("сорок");
        add("счет");
        add("возвращаться");
        add("золотой");
        add("местный");
        add("кухня");
        add("крупный");
        add("решение");
        add("молодая");
        add("тридцать");
        add("роман");
        add("требовать");
        add("компания");
        add("частый");
        add("российский");
        add("рабочий");
        add("потерять");
        add("течение");
        add("синий");
        add("столько");
        add("теплый");
        add("метр");
        add("достать");
        add("железный");
        add("институт");
        add("сообщить");
        add("интерес");
        add("обычный");
        add("появляться");
        add("упасть");
        add("остальной");
        add("половина");
        add("московский");
        add("шесть");
        add("получиться");
        add("качество");
        add("бой");
        add("шея");
        add("вон");
        add("идея");
        add("видимо");
        add("достаточно");
        add("провести");
        add("важный");
        add("трава");
        add("дед");
        add("сознание");
        add("родитель");
        add("простить");
        add("бить");
        add("чай");
        add("поздний");
        add("кивнуть");
        add("род");
        add("исчезнуть");
        add("тонкий");
        add("немецкий");
        add("звук");
        add("отдать");
        add("магазин");
        add("президент");
        add("поэт");
        add("спасибо");
        add("болезнь");
        add("событие");
        add("помочь");
        add("кожа");
        add("лист");
        add("слать");
        add("вспоминать");
        add("прекрасный");
        add("слеза");
        add("надежда");
        add("молча");
        add("сильно");
        add("верный");
        add("литература");
        add("оружие");
        add("готовый");
        add("запах");
        add("неожиданно");
        add("вчера");
        add("вздохнуть");
        add("роль");
        add("рост");
        add("природа");
        add("политический");
        add("точка");
        add("звезда");
        add("петь");
        add("садиться");
        add("фамилия");
        add("характер");
        add("пожалуйста");
        add("выше");
        add("офицер");
        add("толпа");
        add("перестать");
        add("придтись");
        add("уровень");
        add("неизвестный");
        add("кресло");
        add("баба");
        add("секунда");
        add("пожаловать");
        add("банк");
        add("опыт");
        add("тихий");
        add("поскольку");
        add("сапог");
        add("правило");
        add("стекло");
        add("получать");
        add("внутренний");
        add("дочь");
        add("называться");
        add("надеяться");
        add("член");
        add("протянуть");
        add("государственный");
        add("десяток");
        add("глубокий");
        add("цветок");
        add("ах");
        add("желание");
        add("дождь");
        add("впереди");
        add("подходить");
        add("много");
        add("лоб");
        add("улыбка");
        add("борьба");
        add("ворот");
        add("ящик");
        add("этаж");
        add("служить");
        add("вновь");
        add("голубой");
        add("нечего");
        add("революция");
        add("впервые");
        add("сосед");
        add("сестра");
        add("долгий");
        add("чей");
        add("поверить");
        add("ситуация");
        add("взглянуть");
        add("слабый");
        add("количество");
        add("вызывать");
        add("уверенный");
        add("выход");
        add("совет");
        add("дурак");
        add("любимый");
        add("союз");
        add("лето");
        add("ожидать");
        add("пришлый");
        add("висеть");
        add("граница");
        add("цвет");
        add("серьезный");
        add("создать");
        add("интересно");
        add("свобода");
        add("зато");
        add("стул");
        add("уехать");
        add("поезд");
        add("музыка");
        add("быстрый");
        add("тень");
        add("лошадь");
        add("поле");
        add("выглядеть");
        add("учиться");
        add("левый");
        add("разговаривать");
        add("детский");
        add("тип");
        add("суд");
        add("связанный");
        add("горячий");
        add("площадь");
        add("помогать");
        add("счастливый");
        add("повернуться");
        add("позволить");
        add("встретить");
        add("радость");
        add("острый");
        add("возраст");
        add("орган");
        add("карта");
        add("входить");
        add("обнаружить");
        add("король");
        add("слава");
        add("полковник");
        add("мелкий");
        add("бок");
        add("цена");
        add("информация");
        add("мозг");
        add("удовольствие");
        add("воля");
        add("область");
        add("крыша");
        add("нести");
        add("обратно");
        add("современный");
        add("дама");
        add("семь");
        add("веселый");
        add("прислать");
        add("сад");
        add("правительство");
        add("милый");
        add("относиться");
        add("возникать");
        add("мол");
        add("повторить");
        add("название");
        add("средний");
        add("пример");
        add("невозможно");
        add("зеркало");
        add("погибнуть");
        add("американский");
        add("дым");
        add("гореть");
        add("плакать");
        add("весьма");
        add("факт");
        add("двигаться");
        add("рыба");
        add("добавить");
        add("удивиться");
        add("бабушка");
        add("вино");
        add("ибо");
        add("учитель");
        add("действовать");
        add("осторожно");
        add("круг");
        add("папа");
        add("правильно");
        add("недавно");
        add("держаться");
        add("причем");
        add("лететь");
        add("носить");
        add("повод");
        add("лагерь");
        add("птица");
        add("корабль");
        add("мнение");
        add("ночной");
        add("здоровый");
        add("зима");
        add("сухой");
        add("километр");
        add("кровать");
        add("привыкнуть");
        add("прочее");
        add("свободный");
        add("лестница");
        add("неужели");
        add("обязательно");
        add("вверх");
        add("детство");
        add("остров");
        add("статья");
        add("позвонить");
        add("столь");
        add("мешать");
        add("водка");
        add("темнота");
        add("возникнуть");
        add("способный");
        add("станция");
        add("желать");
        add("попробовать");
        add("получаться");
        add("гражданин");
        add("странно");
        add("вскоре");
        add("интересный");
        add("команда");
        add("заболевание");
        add("живот");
        add("ставить");
        add("ради");
        add("тишина");
        add("понятно");
        add("фронт");
        add("щека");
        add("страшно");
        add("район");
        add("наверно");
        add("проводить");
        add("выражение");
        add("кончиться");
        add("куст");
        add("стрелять");
        add("художник");
        add("знак");
        add("завод");
        add("кулак");
        add("использовать");
        add("рот");
        add("пора");
        add("передать");
        add("несмотря");
        add("оттуда");
        add("засмеяться");
        add("волна");
        add("задача");
        add("касаться");
        add("старуха");
        add("войско");
        add("срок");
        add("ужас");
        add("узкий");
        add("материал");
        add("приняться");
        add("нормальный");
        add("крик");
    }};
}