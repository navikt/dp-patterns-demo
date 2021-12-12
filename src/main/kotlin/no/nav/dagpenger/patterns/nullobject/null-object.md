## Null object pattern


### Intensjon
Fjerne kompleksitet i forbindelse med nullsjekker. Sette ord på hva null egentlig betyr i koden.
F.eks: Gjestebruker istedenfor ```user == null```. Avslag istedenfor ```avtale == null```.

Man kan også gjøre det samme hvis det i koden ofte sjekkes etter f.eks: ```customer === "unknown"```. 
Det er dette Fowler referer til som et special case

### Mer lesestoff
Martin Fowler nevner mønsteret under kapittel 10: Simplifying conditional logic, 
og kaller det Introduce special case.
- [Refactoring: Improving the Design of Existing Code](https://learning.oreilly.com/library/view/refactoring-improving-the/9780134757681/ch10.xhtml#ch10lev1sec5)