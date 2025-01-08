import json

class Filme:
    def __init__(self, titulo, ano, classificacao, nota):
        self.titulo = titulo
        self.ano = ano
        self.classificacao = classificacao
        self.nota = nota

    @classmethod
    def from_json(cls, json_data):
        titulo = json_data["titulo"]
        ano = json_data["ano"]
        classificacao = json_data["classificacao"]
        nota = json_data["nota"]
        return cls(titulo, ano, classificacao, nota)


def ler_filmes_from_json(caminho_arquivo):
    with open(caminho_arquivo, "r") as arquivo:
        filmes_json = json.load(arquivo)
        filmes = [Filme.from_json(filme_json) for filme_json in filmes_json]
    return filmes


def listar_filmes_ordenados(filmes):
    filmes_ordenados = sorted(filmes, key=lambda x: x.nota, reverse=True)
    for filme in filmes_ordenados:
        print(f"Título: {filme.titulo} | Ano: {filme.ano} | Classificação: {filme.classificacao} | Nota: {filme.nota}")


caminho_arquivo = "C:/Users/Dyona/Documents/JAVA/Lista2/exe5/filmes.json"


filmes = ler_filmes_from_json(caminho_arquivo)

listar_filmes_ordenados(filmes)
