# Réponses aux questions DuckCorp

**Question (Ex1) :** Une méthode default dans une interface ne peut **pas** accéder aux champs privés de la classe qui l'implémente, car une interface n'a aucune connaissance de l'état interne (les champs) des classes l'implémentant. Elle ne peut utiliser que les méthodes publiques définies dans son propre contrat, comme `getQualityScore()` que isDefective() appelle.
