# 🧮 Calcul Impôt Salarié

## 📌 Description

Ce projet implémente le calcul du salaire imposable d’un employé selon une spécification donnée.
Le programme prend en compte la situation familiale, le nombre d’enfants, les règles d’abattement et les limites du salaire brut afin de déterminer le montant imposable.

Les données de test sont introduites via une source **CSV** et des **tests unitaires** vérifient la conformité des calculs.

---

## ⚙️ Règles de gestion

### 👨‍👩‍👧 Nombre de parts fiscales

| Situation   | Nombre de parts     |
| ----------- | ------------------- |
| Célibataire | 1,5                 |
| Marié       | 2                   |
| Par enfant  | +0,5 part           |
| **Plafond** | **5 parts maximum** |

---

### 💰 Abattement

* Abattement = **30% du salaire brut**
* Plafonné à **300 000 F**

---

### 📉 Bornes du salaire brut

| Condition       | Valeur          |
| --------------- | --------------- |
| Salaire minimum | **60 000 F**    |
| Salaire maximum | **3 000 000 F** |

Tout salaire en dehors de ces limites provoque une **erreur**.

---

## 🧮 Formule appliquée

1. Calcul du nombre de parts
2. Calcul de l’abattement
3. Salaire après abattement
4. Salaire imposable par part :

[
Salaire_imposable = \frac{Salaire_brut - Abattement}{Nombre_de_parts}
]

---

## 🧪 Tests réalisés

Les tests vérifient :

✔️ Le calcul du nombre de parts
✔️ Le plafond de 5 parts
✔️ L’abattement de 30%
✔️ Le plafond d’abattement
✔️ Le salaire minimum et maximum
✔️ Les cas d’erreur (valeurs invalides)

Les tests sont organisés selon la structure :

**Arrange – Act – Assert**

---

## 📂 Structure du projet

```
src/
 ├── main/
 │   └── CalculImpot.java
 └── test/
     └── CalculImpotTest.java
resources/
 └── données_test.csv
```

---

## ▶️ Exécution

1. Importer le projet dans votre IDE (IntelliJ, Eclipse, VS Code…)
2. Lancer les tests unitaires
3. Vérifier que tous les tests passent

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre d’un exercice sur les tests logiciels et le respect d’une spécification fonctionnelle.
