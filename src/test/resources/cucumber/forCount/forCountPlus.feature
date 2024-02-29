Feature: Addition and subtraction operations with different parameters
##  Background: Действия выполняющиеся до каждого сценария
##    Given Начинаем сценарий
#  Scenario Outline: addition operation
#    Given есть <было> записей
#    When добавляем <добавлено> записей
#    When добавляем еще <добавлено2> записей
#    Then получилось <получилось> записей
#
#    Examples:
#      | было | добавлено | добавлено2| получилось |
#      | 19   | 10        | 10        | 29         |
#      | 1    | 17        | 10        | 18         |
#
#  Scenario Outline: subtraction operation
#    Given minus given <was> records
#    When minus delete <deleted> records
#    Then minus left <lefted> records
#
#    Examples:
#      | was  | deleted | lefted  |
#      | 12   | 5       | 7       |
#      | 20   | 9       | 11      |