Projekt aplikacji do oceniania projektów wykonanych przez kursantów. 

Program został napisany w celu poprawienia organizacji pracy oraz ułatwienia wymiany informacji pomiędzy trenerem a uczestnikami kursu w zakresie projektów zaliczeniowych realizowanych w ramach kursu. 

Program został napisany w celu poprawienia organizacji pracy oraz ułatwienia wymiany informacji pomiędzy trenerem a uczestnikami kursu w zakresie projektów zaliczeniowych realizowanych w ramach kursu Back-End Developer. 



Funkcjonalność: 
1 panel logowania (username i hasło). 
	Logowanie sprawdza uprawnienia użytkownika i przenosi odpowiednio do panelu kursant lub trener.

2 panel trenera umożliwia:
	- wprowadzenie i edycję danych kursantów,
	- tworzenie grup i przydział kursantów do grup, 
	- dodawanie projektów do wykonania (temat, opis, termin oddania) i przypisanie ich do grup
	- ocenę projektów 
	- wyświetlenie statystyk w odniesieniu do kursanta, grupy, projektów.

3 panel kursant umożliwia: 
	- podgląd listy projektów do wykonania
	- powiadomienie trenera o wysłaniu danego projektu do oceny. 
	- zmianę hasła do swojego konta

Uruchomienie: 
Ściągnąć repozytorium na dysk. 
Po rozpakowaniu, otworzyć pliki ocena_projektu.sql i op_inserty.sql w dowolnym aplikacji MySQL (np. MySQL Workbench). 
Wykonać polecenia z pliku ocena_projektu.sql by utworzyć bazę danych z tabelami. Z pliku op_inserty.sql wykonać polecenia insertów.

Zaimportować projekt do dowolnego środowiska JAVA IDE (Eclipse, InteliJ) i uruchomić program (kod napisany w wersji JAVA 8). 
Repozytorium zawiera również plik wykonywalny uruchamiany z poziomu systemu operacyjnego "ocena_projektów.jar".

Testowe konta do logowania w aplikacji: 
Trener: username: "admin", pass: "admin"
Kursant: username: "kursant1", pass "test"


Projekt wykonali: 
Aneta Zolech<br>
Aleksander Rotnicki<br>
Dariusz Górniakowski<br>
Marcin Hoinka <br> 

