from Reta import Reta
from Ponto2D import Ponto2D
from ObjetoSobrepostoException import ObjetoSobrepostoException

class EspacoGeometrico:
    def __init__(self):
        self.retas = []
        self.pontos = []

    def adicionarReta(self, reta):
        for outra_reta in self.retas:
            if reta.intercepta(outra_reta):
                raise ObjetoSobrepostoException("Reta intercepta outra reta.")
        self.retas.append(reta)

    def adicionarPonto(self, ponto):
        for reta in self.retas:
            if reta.estaNaReta(ponto):
                raise ObjetoSobrepostoException("Ponto está na reta.")
        self.pontos.append(ponto)
