class Reta:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def intercepta(self, outra_reta):
        return self.a != outra_reta.a

    def estaNaReta(self, ponto):
        return ponto.y == (self.a * ponto.x + self.b)
