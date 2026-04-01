# Réponses aux questions DuckCorp

**Question (Ex1) :** Une méthode default dans une interface ne peut **pas** accéder aux champs privés de la classe qui l'implémente, car une interface n'a aucune connaissance de l'état interne (les champs) des classes l'implémentant. Elle ne peut utiliser que les méthodes publiques définies dans son propre contrat, comme getQualityScore() que isDefective() appelle.

**Question (Ex2) :** En Java, l'héritage multiple de classes est interdit. Si Machine était une interface et Maintainable une classe abstraite, nos presses auraient dû hériter de Maintainable. Or, on choisit une classe abstraite pour mutualiser de l'état (les champs condition, capacity) et du code (maintain()), et une interface pour définir un contrat de capacité ("est maintenable") qu'importe l'objet.

**Question (Ex4) :** Stock<Duck> exige exactement un stock de Duck. Si on avait un Stock<StandardDuck>, la compilation échouerait car les génériques sont invariants en Java (un Stock<StandardDuck> n'est pas un Stock<Duck>). Stock<? extends Duck> permet d'accepter n'importe quel stock contenant un sous-type de Duck.

**Question (Ex5) :** Collections.unmodifiableList() garantit l'encapsulation. Si on retournait la liste interne, du code externe pourrait faire factory.getMachines().clear() et détruire l'usine. On protège la structure, mais on peut quand même modifier l'état interne des machines (via machine.maintain()) car les références pointent vers les mêmes objets mutables en mémoire.