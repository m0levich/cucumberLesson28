#language: ru
@all
Функционал: Проверка работы auto.ru
  Проверка количества в таблице и кнопке

  @lesson28
  Структура сценария: : Проверка количества марки/модели в таблице и в кнопке
    Когда перейти "https://www.auto.ru"
    Тогда заголовок содержит "Авто.ру"
    И сохранить количество объявлений, отображаемых после названия автомобиля <марка>
    И перейти на страницу <марка> автомобилей
    То отображается кнопка с текстом, содержащим количество объявлений как и сохраненного ранее количества
    И сохранить количество объявлений конкретной <модель> автомобиля
    И переход на страницу <модель>
    Тогда отображается кнопка с текстом, содержащим количество объявлений по определенной модели

    @example1
    Примеры:
      | марка | модель |
      | MINI  | Cabrio |

    @example2and3
    Примеры:
      | марка   | модель |
      | Porsche | Macan  |
      | Skoda   | Karoq  |

