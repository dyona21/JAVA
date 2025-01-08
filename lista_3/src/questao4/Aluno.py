from Pessoa import Pessoa


class Aluno(Pessoa):
    def __init__(self, nome, notas):
        super().__init__(nome)
        self.notas = notas

    def calcularMedia(self):
        return sum(self.notas) / len(self.notas)

    def repr(self):
        media = self.calcularMedia()
        status = "aprovado" if media >= 7 else "em exame"
        return f"Aluno: {self.nome}, Notas: {', '.join(map(str, self.notas))}, Média: {media}, Status: {status}"