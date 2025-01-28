CryptoAnalyzer: Шифрувальник на основі шифру Цезаря
Опис проєкту
CryptoAnalyzer — це програма для шифрування, розшифрування та brute-force розшифрування текстів, використовуючи шифр Цезаря. Програма підтримує три мови: англійську, українську та російську.

Функціонал
ENCRYPT: Зашифрувати текст, зсунувши символи на вказаний ключ.
DECRYPT: Розшифрувати текст, використовуючи відомий ключ.
BRUTE_FORCE: Автоматично знайти ключ і розшифрувати текст.
Як використовувати
Команди
Програма приймає три команди:

ENCRYPT: Шифрує текст.
DECRYPT: Розшифровує текст із відомим ключем.
BRUTE_FORCE: Автоматично підбирає ключ і розшифровує текст.
Приклади використання
Команди виконуються через термінал за допомогою команди java -jar:

# Зашифрувати текст
java -jar encriptor.oleh.shmauts.jar ENCRYPT /path/to/file.txt 5

# Розшифрувати текст
java -jar encriptor.oleh.shmauts.jar DECRYPT /path/to/file[ENCRYPTED].txt 5

# Brute-force розшифрування
java -jar encriptor.oleh.shmauts.jar BRUTE_FORCE /path/to/file[ENCRYPTED].txt
