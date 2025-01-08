class ObjetoSobrepostoException(Exception):
    def __init__(self, message="Objeto está sobreposto a outro."):
        super().__init__(message)
