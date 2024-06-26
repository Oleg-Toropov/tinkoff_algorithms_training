<h1 class="title">Тинькофф (4 задание, вечный контест)</h1>
<p><b>Время: 2 сек.<br>Память: 256 Мб<br>Сложность: ?</b></p>
<p>У Кости есть бумажка, на которой написано n чисел. Также у него есть возможность не больше, чем k раз, взять любое число с бумажки, после чего закрасить одну из старых цифр, а на ее месте написать новую произвольную цифру.</p>
<p>На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?</p>

<h2>Формат ввода</h2>
<p>В первой строке входного файла даны два целых числа n, k — количество чисел на бумажке и ограничение на число операций.</p>
<p>(1 ≤ n ≤ 1000, 1 ≤ k ≤10<sup>4</sup>).</p>
<p>Во второй строке записано n чисел a<sub>i</sub> — числа на бумажке (1 ≤ a<sub>i</sub> ≤ 10<sup>9</sup>).</p>

<h2>Формат вывода</h2>
<p>В выходной файл выведите одно число — максимальную разность между конечной и начальной суммой.</p>

<h2>Замечание</h2>
<p>В первом примере Костя может изменить две единицы на две девятки, в результате чего сумма чисел увеличится на 16.</p>
<p>Во втором примере Костя меняет число 85 на 95.</p>
<p>В третьем примере можно ничего не менять.</p>
<p>Обратите внимание, что ответ может превышать вместимость 32-битного типа данных.</p>

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
        <td>5 2<br>
            1 2 1 3 5</td>
        <td>16</td>
     </tr>
     <tr>
        <td>3 1<br>
            99 5 85</td>
        <td>10</td>
     </tr>
     <tr>
        <td>1 10<br>
            9999</td>
        <td>0</td>
     </tr>
  </tbody>
</table>