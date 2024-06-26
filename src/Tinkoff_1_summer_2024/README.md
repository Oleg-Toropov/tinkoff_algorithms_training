<h1 class="title">Тинькофф (1 задание, Старт карьеры Java-разработчик (лето 2024))</h1>
<p><b>Время: 1 сек.<br>Память: 64 Мб<br>Сложность: ?</b></p>
<p>Олег — настоящий герой, чьи школьные будни наполнены заботами, уроками и оценками. Он изо всех сил старается, но, как и любой человек, он время от времени допускает ошибки и получает не самые лучшие оценки.</p>
<p>Сегодня Олег стоит перед особенным испытанием — ему предстоит показать своим родителям свои оценки. Родители попросили показать ему все его оценки за какие-то последовательные 7 дней. Оценки представляют собой последовательность целых чисел от 2 до 5 включительно — по одной оценке на каждый день. Олег хочет выбрать такой непрерывный отрезок своих оценок, чтобы в этом отрезке не было оценок 2 и 3, а количество оценок 5 было максимальным.</p>
<p>Помогите Олегу найти этот особенный момент, когда его школьный свет преобладает над тьмой, и его оценки сияют наиболее ярко!</p>

<h2>Формат ввода</h2>
<p>Первая строка содержит одно натуральное число n — количество оценок (1 ≤ n ≤ 10<sup>5</sup>). Вторая строка содержит n целых чисел — по оценке m за каждый день (2 ≤ m ≤ 5).</p>

<h2>Формат вывода</h2>
<p>Выведите количество пятерок в выбранном Олегом отрезке, удовлетворяющем всем условиям. Если такого отрезка не существует, выведите −1.</p>

<h3>Примеры</h3>
<table class="sample-tests">
  <thead>
     <tr>
        <th>Ввод</th>
        <th>Вывод</th>
     </tr>
  </thead>
  <tbody>
     <tr>
        <td>9<br>5 5 4 5 4 5 4 5 4</td>
        <td>4</td>
     </tr>
     <tr>
        <td>8<br>3 4 4 4 4 5 4 5</td>
        <td>2</td>
     </tr>
     <tr>
        <td>10<br>5 5 5 5 5 3 5 5 5 5</td>
        <td>-1</td>
     </tr>

  </tbody>
</table>