#language: ru

Функционал: Cucumber

  @all
  Структура сценария: ценарий: Ozon.ru Test

    * перейти по ссылке "http://www.ozon.ru/"
    * выполняется авторизация
    * выполняется поиск по "iPhone 7 Plus/8 Plus Black"
    * добавляем товары в корзину "<item1>"
    * добавляем товары в корзину "<item2>"
    * добавляем товары в корзину "<item3>"
    * добавляем товары в корзину "<item4>"
    * добавляем товары в корзину "<item5>"
    * переходим в корзину
    * сравниваем товары в корзине с "<item1>", "<item2>", "<item3>", "<item4>", "<item5>"
    * очищаем корзину
    * выходим из учетной записи
    * выполняется авторизация
    * проверяем, что корзина пуста

    Примеры:
      | item1                                                 | item2                                     | item3                                                       | item4                                                    | item5                                             |
      | Deppa FIFA Забивака_3 чехол для Apple iPhone 7/8 Plus | Moshi Napa чехол для iPhone 7 Plus/8 Plus | Celly Gelskin чехол-накладка для Apple iPhone 7 Plus/8 Plus | Deppa Gel Plus Case чехол для Apple iPhone 7 Plus/8 Plus | UAG Pathfinder чехол для Apple iPhone 8/7/6s Plus |




