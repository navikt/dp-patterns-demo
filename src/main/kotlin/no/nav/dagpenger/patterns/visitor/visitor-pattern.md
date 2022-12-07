## Visitor pattern

### TLDR 
Brukes til å hente innkapsulerte felter fra objekter.

Opprett nye visitorer for hver ting du skal eksponere fra et innkapslet objekt.
Dette gjør at man ikke får masse avhengigheter til enkeltmetoder i modellen,
samt at det er lett å endre og slette funksjonalitet ved behov. Løs kobling.

Se eksempler i pakken: `/søknad/visitor/.kt`

For mer eksempel, kjør main metoden i `/søknad/Søknad.kt`

### Hvorfor bruker man visitor pattern?
TODO

### Kata forslag
- Legge til en visitor
- Endre i modellen. Hvordan det tvinger visitorene til å oppdateres

### Læringsmuligheter
- Lag en alternativ implementasjon med sealed classes. Se [visitor as a sum type](https://blog.ploeh.dk/2018/06/25/visitor-as-a-sum-type/)