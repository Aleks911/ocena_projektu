Projekt aplikacji do oceniania projektów wykonanych przez kursantów. 

Program został napisany w celu poprawienia organizacji pracy oraz ułatwienia wymiany informacji pomiędzy trenerem a uczestnikami kursu w zakresie projektów zaliczeniowych realizowanych w ramach kursu. 

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
Po rozpakowaniu, otworzyć pliki ocena_projektu.sql i op_inserty.sql w aplikacji do MySQL (np. MySQL Workbench). 
Wykonać polecenia z pliku ocena_projektu.sql by utworzyć bazę danych i tabele. Z pliku op_inserty.sql wykonać polecenia insertów.
Zaimportować projekt do dowolnego środowiska JAVA IDE (Eclipse, InteliJ) i uruchhomić program. 

Repozytorium zawiera również plik wykonywalny uruchamiany z poziomu systemu operacyjnego [PODAĆ ===== NAZWE ======= PLIKU]

Przykładowe konta do logowania w aplikacji: 
Trener: username: "admin", pass: "admin"
Kursant: username: "kursant1", pass "test"  


Projekt wykonali: 
Aneta Zolech
Aleksander Rotnicki
Dariusz Górniakowski
Marcin Hoinka



