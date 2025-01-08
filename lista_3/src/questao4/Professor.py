from Pessoa import Pessoa


class Professor(Pessoa):
    def __init__(self, nome, salario):
        super().__init__(nome)
        self.salario = salario

    def repr(self):
        return f"Professor: {self.nome}, Salário: {self.salario}"