from Aluno import Aluno
from Professor import Professor
from Pessoa import Pessoa


professor1 = Professor("João", 5000)
professor2 = Professor("Maria", 6000)

aluno1 = Aluno("Pedro", [8, 7, 6])
aluno2 = Aluno("Ana", [6, 5, 4])
aluno3 = Aluno("Carlos", [9, 8, 9])
aluno4 = Aluno("Mariana", [5, 6, 7])
aluno5 = Aluno("Lucas", [7, 7, 7])


print(professor1.repr())
print(professor2.repr())
print(aluno1.repr())
print(aluno2.repr())
print(aluno3.repr())
print(aluno4.repr())
print(aluno5.repr())