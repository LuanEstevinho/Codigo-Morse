# Projeto Código Morse - JavaFX

## ✅ Configuração Concluída!

O projeto foi convertido para Maven e todas as dependências do JavaFX foram baixadas automaticamente.

## 🚀 Como Rodar no IntelliJ

### ✅ Opção 1: Usar o Botão ▶️ Play (Mais Fácil!)
1. **Já está configurado!** 🎉
2. No canto superior direito, selecione **"Run Morse (Maven)"** no dropdown
3. Clique no botão verde ▶️ **Run**
4. Pronto! A aplicação vai abrir!

### Opção 2: Usar o Terminal do IntelliJ
1. Abra o terminal (Alt+F12)
2. Execute:
   ```
   mvn javafx:run
   ```

### Opção 3: Configurar Manualmente (se necessário)
Se por algum motivo a configuração não aparecer:
1. Vá em **Run → Edit Configurations**
2. Clique no `+` → **Maven**
3. Configure:
   - **Name:** Run Morse
   - **Command line:** `javafx:run`
   - **Working directory:** `$ProjectFileDir$`
4. Clique **Apply** e depois **OK**
5. Agora é só clicar no botão ▶️ **Run**

## 📁 Estrutura do Projeto
```
Codigo-Morse/
├── src/
│   └── main/
│       └── java/
│           ├── ArvoreMorse.java
│           ├── Main.java
│           └── NoMorse.java
├── pom.xml
└── README.md
```

## 🔧 O que foi feito?
- ✅ Criado arquivo `pom.xml` com dependências do JavaFX
- ✅ Reorganizado projeto na estrutura Maven padrão
- ✅ Movido arquivos `.java` para `src/main/java/`
- ✅ Baixado todas as dependências automaticamente
- ✅ Projeto compilado com sucesso!

## 💡 Dicas
- ✅ **Botão ▶️ Play funciona!** - A configuração foi criada automaticamente
- Se o IntelliJ não reconhecer o projeto Maven automaticamente, clique com botão direito no `pom.xml` → **Add as Maven Project**
- Para recarregar as dependências: **Maven (barra lateral direita) → Reload All Maven Projects**
- Se a configuração "Run Morse (Maven)" não aparecer, feche e reabra o projeto

## ❓ Por que tinha a pasta `out` duplicada?
- **`out/`** - Pasta antiga gerada pelo IntelliJ quando compilava sem Maven (já removida ✅)
- **`target/`** - Pasta nova gerada pelo Maven (usamos essa agora!)
- Agora só temos uma pasta de compilação: `target/`

## 🎮 Comandos Maven Úteis
```powershell
mvn clean install    # Compila o projeto
mvn javafx:run       # Executa a aplicação
mvn clean           # Limpa os arquivos compilados
```

---
**Projeto convertido com sucesso! Agora é só rodar! 🚀**
