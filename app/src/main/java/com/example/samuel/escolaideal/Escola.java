package com.example.samuel.escolaideal;

public class Escola {
    private int anoCenso,cod, codCidade,situacaoFuncionamento,situacaoCenso,codUf,codMunicipio,codDistrito,tipoLocalizacao,
    regulamentada,salasExistentes,salasUtilizadas,televisores,videoCassetes,dvds,parabolicas,aparelhosSom,datashows,fax,
            foto,computadores,computadoresAdm,computadoresAlunos,funcionarios,
    copiadoras,retroprojetores,impressoras,atividadeComplementar,socioEconomico,dependenciaAdministrativa;
    private String nome,cidade,estado,regiao,situacaoFuncionamentoTxt,dependenciaAdministrativaTxt,
            inicioAno,fimAno,siglaUf,nomeMunicipio,nomeDistrito,endereco,latitude,longitude,nomeTitulo,
            inicioAnoTxt,fimAnoTxt,tipoLocalizacaoTxt,regulamentadaTxt;
    private boolean aguaCacimba,aguaFiltrada,aguaInexistente,aguaPocoArtesiano,aguaPublica,aguaRio,almoxarifado,energiaPublica,
            energiaGerador,energiaOutros,energiaInexistente,esgotoPublico,esgotoFossa,esgotoInexistente,lixoColetaPeriodica,
            lixoQueima,lixoJogaOutraArea,lixoRecicla,lixoEnterra,lixoOutros,salaDiretoria,salaProfessores,laboratorioInformatica,
            laboratorioCiencias,atendimentoEspecial,quadraCoberta,quadraDescoberta,cozinha,biblioteca,salaLeitura,parqueInfantil,
            bercario,sanitarioForaPredio,sanitarioDentroPredio,sanitarioEducInfant,sanitarioPNE,dependenciasPNE,secretaria,
            banheiroChuveiro,refeitorio,despensa,auditorio,patioCoberto,patioDescoberto,alojamentoAluno,
            alojamentoProfessor,areaVerde,lavanderia,internet,bandaLarga,alimentacao,aee,ensinoRegular,regCreche,regPreescola,
            regFundamental8,regFundamental9,regMedioMedio,regMedioIntegrado,regMedioNormal,regMedioProfissional,ensinoEspecial,
            espCreche,espPreescola,espFundamental8,espFundamental9,espMedioMedio,espMedioIntegrado,espMedioNormal,
            espMedioProfissional,espEjaFundamental,espEjaMedio,ensinoEja,ejaFundamental,ejaMedio,ejaProjovem,ciclos,fimDeSemana
            ,pedagogiaAlternancia;
        private double idebAI,idebAF,enemMediaGeral,enemMediaObjetiva,formacaoDocente,enemPortugues,enemMatematica,enemHumanas
                ,enemNaturais,enemRedacao;

    public Escola() {
    }
    public Escola(int cod){
        this.cod = cod;
    }

    public Escola(int anoCenso, int cod, int codCidade, int situacaoFuncionamento, String nome, String cidade, String estado, String regiao, int dependenciaAdministrativa, String situacaoFuncionamentoTxt, String dependenciaAdministrativaTxt, double idebAI, double idebAF, double enemMediaGeral) {
        this.anoCenso = anoCenso;
        this.cod = cod;
        this.codCidade = codCidade;
        this.situacaoFuncionamento = situacaoFuncionamento;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
        this.dependenciaAdministrativa = dependenciaAdministrativa;
        this.situacaoFuncionamentoTxt = situacaoFuncionamentoTxt;
        this.dependenciaAdministrativaTxt = dependenciaAdministrativaTxt;
        this.idebAI = idebAI;
        this.idebAF = idebAF;
        this.enemMediaGeral = enemMediaGeral;
    }

    public String toStringBuscaAvancada() {
        return "{" +
                "anoCenso=" + anoCenso +
                ", cod=" + cod +
                ", codCidade=" + codCidade +
                ", situacaoFuncionamento=" + situacaoFuncionamento +
                ", dependenciaAdministrativa=" + dependenciaAdministrativa +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                ", situacaoFuncionamentoTxt='" + situacaoFuncionamentoTxt + '\'' +
                ", dependenciaAdministrativaTxt='" + dependenciaAdministrativaTxt + '\'' +
                ", idebAI=" + idebAI +
                ", idebAF=" + idebAF +
                ", enemMediaGeral=" + enemMediaGeral +
                '}';
    }



    @Override
    public String toString() {
        return "{" +
                "anoCenso=" + anoCenso +
                ", cod=" + cod +
                ", codCidade=" + codCidade +
                ", situacaoFuncionamento=" + situacaoFuncionamento +
                ", situacaoCenso=" + situacaoCenso +
                ", codUf=" + codUf +
                ", codMunicipio=" + codMunicipio +
                ", codDistrito=" + codDistrito +
                ", tipoLocalizacao=" + tipoLocalizacao +
                ", regulamentada=" + regulamentada +
                ", salasExistentes=" + salasExistentes +
                ", salasUtilizadas=" + salasUtilizadas +
                ", televisores=" + televisores +
                ", videoCassetes=" + videoCassetes +
                ", dvds=" + dvds +
                ", parabolicas=" + parabolicas +
                ", aparelhosSom=" + aparelhosSom +
                ", datashows=" + datashows +
                ", fax=" + fax +
                ", foto=" + foto +
                ", computadores=" + computadores +
                ", computadoresAdm=" + computadoresAdm +
                ", computadoresAlunos=" + computadoresAlunos +
                ", funcionarios=" + funcionarios +
                ", copiadoras=" + copiadoras +
                ", retroprojetores=" + retroprojetores +
                ", impressoras=" + impressoras +
                ", atividadeComplementar=" + atividadeComplementar +
                ", socioEconomico=" + socioEconomico +
                ", dependenciaAdministrativa=" + dependenciaAdministrativa +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                ", situacaoFuncionamentoTxt='" + situacaoFuncionamentoTxt + '\'' +
                ", dependenciaAdministrativaTxt='" + dependenciaAdministrativaTxt + '\'' +
                ", inicioAno='" + inicioAno + '\'' +
                ", fimAno='" + fimAno + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                ", nomeMunicipio='" + nomeMunicipio + '\'' +
                ", nomeDistrito='" + nomeDistrito + '\'' +
                ", endereco='" + endereco + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", nomeTitulo='" + nomeTitulo + '\'' +
                ", inicioAnoTxt='" + inicioAnoTxt + '\'' +
                ", fimAnoTxt='" + fimAnoTxt + '\'' +
                ", tipoLocalizacaoTxt='" + tipoLocalizacaoTxt + '\'' +
                ", regulamentadaTxt='" + regulamentadaTxt + '\'' +
                ", aguaCacimba=" + aguaCacimba +
                ", aguaFiltrada=" + aguaFiltrada +
                ", aguaInexistente=" + aguaInexistente +
                ", aguaPocoArtesiano=" + aguaPocoArtesiano +
                ", aguaPublica=" + aguaPublica +
                ", aguaRio=" + aguaRio +
                ", almoxarifado=" + almoxarifado +
                ", energiaPublica=" + energiaPublica +
                ", energiaGerador=" + energiaGerador +
                ", energiaOutros=" + energiaOutros +
                ", energiaInexistente=" + energiaInexistente +
                ", esgotoPublico=" + esgotoPublico +
                ", esgotoFossa=" + esgotoFossa +
                ", esgotoInexistente=" + esgotoInexistente +
                ", lixoColetaPeriodica=" + lixoColetaPeriodica +
                ", lixoQueima=" + lixoQueima +
                ", lixoJogaOutraArea=" + lixoJogaOutraArea +
                ", lixoRecicla=" + lixoRecicla +
                ", lixoEnterra=" + lixoEnterra +
                ", lixoOutros=" + lixoOutros +
                ", salaDiretoria=" + salaDiretoria +
                ", salaProfessores=" + salaProfessores +
                ", laboratorioInformatica=" + laboratorioInformatica +
                ", laboratorioCiencias=" + laboratorioCiencias +
                ", atendimentoEspecial=" + atendimentoEspecial +
                ", quadraCoberta=" + quadraCoberta +
                ", quadraDescoberta=" + quadraDescoberta +
                ", cozinha=" + cozinha +
                ", biblioteca=" + biblioteca +
                ", salaLeitura=" + salaLeitura +
                ", parqueInfantil=" + parqueInfantil +
                ", bercario=" + bercario +
                ", sanitarioForaPredio=" + sanitarioForaPredio +
                ", sanitarioDentroPredio=" + sanitarioDentroPredio +
                ", sanitarioEducInfant=" + sanitarioEducInfant +
                ", sanitarioPNE=" + sanitarioPNE +
                ", dependenciasPNE=" + dependenciasPNE +
                ", secretaria=" + secretaria +
                ", banheiroChuveiro=" + banheiroChuveiro +
                ", refeitorio=" + refeitorio +
                ", despensa=" + despensa +
                ", auditorio=" + auditorio +
                ", patioCoberto=" + patioCoberto +
                ", patioDescoberto=" + patioDescoberto +
                ", alojamentoAluno=" + alojamentoAluno +
                ", alojamentoProfessor=" + alojamentoProfessor +
                ", areaVerde=" + areaVerde +
                ", lavanderia=" + lavanderia +
                ", internet=" + internet +
                ", bandaLarga=" + bandaLarga +
                ", alimentacao=" + alimentacao +
                ", aee=" + aee +
                ", ensinoRegular=" + ensinoRegular +
                ", regCreche=" + regCreche +
                ", regPreescola=" + regPreescola +
                ", regFundamental8=" + regFundamental8 +
                ", regFundamental9=" + regFundamental9 +
                ", regMedioMedio=" + regMedioMedio +
                ", regMedioIntegrado=" + regMedioIntegrado +
                ", regMedioNormal=" + regMedioNormal +
                ", regMedioProfissional=" + regMedioProfissional +
                ", ensinoEspecial=" + ensinoEspecial +
                ", espCreche=" + espCreche +
                ", espPreescola=" + espPreescola +
                ", espFundamental8=" + espFundamental8 +
                ", espFundamental9=" + espFundamental9 +
                ", espMedioMedio=" + espMedioMedio +
                ", espMedioIntegrado=" + espMedioIntegrado +
                ", espMedioNormal=" + espMedioNormal +
                ", espMedioProfissional=" + espMedioProfissional +
                ", espEjaFundamental=" + espEjaFundamental +
                ", espEjaMedio=" + espEjaMedio +
                ", ensinoEja=" + ensinoEja +
                ", ejaFundamental=" + ejaFundamental +
                ", ejaMedio=" + ejaMedio +
                ", ejaProjovem=" + ejaProjovem +
                ", ciclos=" + ciclos +
                ", fimDeSemana=" + fimDeSemana +
                ", pedagogiaAlternancia=" + pedagogiaAlternancia +
                ", idebAI=" + idebAI +
                ", idebAF=" + idebAF +
                ", enemMediaGeral=" + enemMediaGeral +
                ", enemMediaObjetiva=" + enemMediaObjetiva +
                ", formacaoDocente=" + formacaoDocente +
                ", enemPortugues=" + enemPortugues +
                ", enemMatematica=" + enemMatematica +
                ", enemHumanas=" + enemHumanas +
                ", enemNaturais=" + enemNaturais +
                ", enemRedacao=" + enemRedacao +
                '}';
    }

    public double getEnemPortugues() {
        return enemPortugues;
    }

    public void setEnemPortugues(double enemPortugues) {
        this.enemPortugues = enemPortugues;
    }

    public double getEnemMatematica() {
        return enemMatematica;
    }

    public void setEnemMatematica(double enemMatematica) {
        this.enemMatematica = enemMatematica;
    }

    public double getEnemHumanas() {
        return enemHumanas;
    }

    public void setEnemHumanas(double enemHumanas) {
        this.enemHumanas = enemHumanas;
    }

    public double getEnemNaturais() {
        return enemNaturais;
    }

    public void setEnemNaturais(double enemNaturais) {
        this.enemNaturais = enemNaturais;
    }

    public double getEnemRedacao() {
        return enemRedacao;
    }

    public void setEnemRedacao(double enemRedacao) {
        this.enemRedacao = enemRedacao;
    }

    public boolean isPedagogiaAlternancia() {
        return pedagogiaAlternancia;
    }

    public void setPedagogiaAlternancia(boolean pedagogiaAlternancia) {
        this.pedagogiaAlternancia = pedagogiaAlternancia;
    }

    public boolean isFimDeSemana() {
        return fimDeSemana;
    }

    public void setFimDeSemana(boolean fimDeSemana) {
        this.fimDeSemana = fimDeSemana;
    }

    public boolean isCiclos() {
        return ciclos;
    }

    public void setCiclos(boolean ciclos) {
        this.ciclos = ciclos;
    }

    public int getAnoCenso() {
        return anoCenso;
    }

    public int getCod() {
        return cod;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public int getSituacaoFuncionamento() {
        return situacaoFuncionamento;
    }

    public int getSituacaoCenso() {
        return situacaoCenso;
    }

    public int getCodUf() {
        return codUf;
    }

    public int getCodMunicipio() {
        return codMunicipio;
    }

    public int getCodDistrito() {
        return codDistrito;
    }

    public int getTipoLocalizacao() {
        return tipoLocalizacao;
    }

    public int getRegulamentada() {
        return regulamentada;
    }

    public int getSalasExistentes() {
        return salasExistentes;
    }

    public int getSalasUtilizadas() {
        return salasUtilizadas;
    }

    public int getTelevisores() {
        return televisores;
    }

    public int getVideoCassetes() {
        return videoCassetes;
    }

    public int getDvds() {
        return dvds;
    }

    public int getParabolicas() {
        return parabolicas;
    }

    public int getAparelhosSom() {
        return aparelhosSom;
    }

    public int getDatashows() {
        return datashows;
    }

    public int getFax() {
        return fax;
    }

    public int getFoto() {
        return foto;
    }

    public int getComputadores() {
        return computadores;
    }

    public int getComputadoresAdm() {
        return computadoresAdm;
    }

    public int getComputadoresAlunos() {
        return computadoresAlunos;
    }

    public int getFuncionarios() {
        return funcionarios;
    }

    public int getCopiadoras() {
        return copiadoras;
    }

    public int getRetroprojetores() {
        return retroprojetores;
    }

    public int getImpressoras() {
        return impressoras;
    }

    public int getAtividadeComplementar() {
        return atividadeComplementar;
    }

    public int getSocioEconomico() {
        return socioEconomico;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getDependenciaAdministrativa() {
        return dependenciaAdministrativa;
    }

    public String getSituacaoFuncionamentoTxt() {
        return situacaoFuncionamentoTxt;
    }

    public String getDependenciaAdministrativaTxt() {
        return dependenciaAdministrativaTxt;
    }

    public String getInicioAno() {
        return inicioAno;
    }

    public String getFimAno() {
        return fimAno;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public String getNomeDistrito() {
        return nomeDistrito;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public String getInicioAnoTxt() {
        return inicioAnoTxt;
    }

    public String getFimAnoTxt() {
        return fimAnoTxt;
    }

    public String getTipoLocalizacaoTxt() {
        return tipoLocalizacaoTxt;
    }

    public String getRegulamentadaTxt() {
        return regulamentadaTxt;
    }

    public boolean isAguaCacimba() {
        return aguaCacimba;
    }

    public boolean isAguaFiltrada() {
        return aguaFiltrada;
    }

    public boolean isAguaInexistente() {
        return aguaInexistente;
    }

    public boolean isAguaPocoArtesiano() {
        return aguaPocoArtesiano;
    }

    public boolean isAguaPublica() {
        return aguaPublica;
    }

    public boolean isAguaRio() {
        return aguaRio;
    }

    public boolean isAlmoxarifado() {
        return almoxarifado;
    }

    public boolean isEnergiaPublica() {
        return energiaPublica;
    }

    public boolean isEnergiaGerador() {
        return energiaGerador;
    }

    public boolean isEnergiaOutros() {
        return energiaOutros;
    }

    public boolean isEnergiaInexistente() {
        return energiaInexistente;
    }

    public boolean isEsgotoPublico() {
        return esgotoPublico;
    }

    public boolean isEsgotoFossa() {
        return esgotoFossa;
    }

    public boolean isEsgotoInexistente() {
        return esgotoInexistente;
    }

    public boolean isLixoColetaPeriodica() {
        return lixoColetaPeriodica;
    }

    public boolean isLixoQueima() {
        return lixoQueima;
    }

    public boolean isLixoJogaOutraArea() {
        return lixoJogaOutraArea;
    }

    public boolean isLixoRecicla() {
        return lixoRecicla;
    }

    public boolean isLixoEnterra() {
        return lixoEnterra;
    }

    public boolean isLixoOutros() {
        return lixoOutros;
    }

    public boolean isSalaDiretoria() {
        return salaDiretoria;
    }

    public boolean isSalaProfessores() {
        return salaProfessores;
    }

    public boolean isLaboratorioInformatica() {
        return laboratorioInformatica;
    }

    public boolean isLaboratorioCiencias() {
        return laboratorioCiencias;
    }

    public boolean isAtendimentoEspecial() {
        return atendimentoEspecial;
    }

    public boolean isQuadraCoberta() {
        return quadraCoberta;
    }

    public boolean isQuadraDescoberta() {
        return quadraDescoberta;
    }

    public boolean isCozinha() {
        return cozinha;
    }

    public boolean isBiblioteca() {
        return biblioteca;
    }

    public boolean isSalaLeitura() {
        return salaLeitura;
    }

    public boolean isParqueInfantil() {
        return parqueInfantil;
    }

    public boolean isBercario() {
        return bercario;
    }

    public boolean isSanitarioForaPredio() {
        return sanitarioForaPredio;
    }

    public boolean isSanitarioDentroPredio() {
        return sanitarioDentroPredio;
    }

    public boolean isSanitarioEducInfant() {
        return sanitarioEducInfant;
    }

    public boolean isSanitarioPNE() {
        return sanitarioPNE;
    }

    public boolean isDependenciasPNE() {
        return dependenciasPNE;
    }

    public boolean isSecretaria() {
        return secretaria;
    }

    public boolean isBanheiroChuveiro() {
        return banheiroChuveiro;
    }

    public boolean isRefeitorio() {
        return refeitorio;
    }

    public boolean isDespensa() {
        return despensa;
    }

    public boolean isAuditorio() {
        return auditorio;
    }

    public boolean isPatioCoberto() {
        return patioCoberto;
    }

    public boolean isPatioDescoberto() {
        return patioDescoberto;
    }

    public boolean isAlojamentoAluno() {
        return alojamentoAluno;
    }

    public boolean isAlojamentoProfessor() {
        return alojamentoProfessor;
    }

    public boolean isAreaVerde() {
        return areaVerde;
    }

    public boolean isLavanderia() {
        return lavanderia;
    }

    public boolean isInternet() {
        return internet;
    }

    public boolean isBandaLarga() {
        return bandaLarga;
    }

    public boolean isAlimentacao() {
        return alimentacao;
    }

    public boolean isAee() {
        return aee;
    }

    public boolean isEnsinoRegular() {
        return ensinoRegular;
    }

    public boolean isRegCreche() {
        return regCreche;
    }

    public boolean isRegPreescola() {
        return regPreescola;
    }

    public boolean isRegFundamental8() {
        return regFundamental8;
    }

    public boolean isRegFundamental9() {
        return regFundamental9;
    }

    public boolean isRegMedioMedio() {
        return regMedioMedio;
    }

    public boolean isRegMedioIntegrado() {
        return regMedioIntegrado;
    }

    public boolean isRegMedioNormal() {
        return regMedioNormal;
    }

    public boolean isRegMedioProfissional() {
        return regMedioProfissional;
    }

    public boolean isEnsinoEspecial() {
        return ensinoEspecial;
    }

    public boolean isEspCreche() {
        return espCreche;
    }

    public boolean isEspPreescola() {
        return espPreescola;
    }

    public boolean isEspFundamental8() {
        return espFundamental8;
    }

    public boolean isEspFundamental9() {
        return espFundamental9;
    }

    public boolean isEspMedioMedio() {
        return espMedioMedio;
    }

    public boolean isEspMedioIntegrado() {
        return espMedioIntegrado;
    }

    public boolean isEspMedioNormal() {
        return espMedioNormal;
    }

    public boolean isEspMedioProfissional() {
        return espMedioProfissional;
    }

    public boolean isEspEjaFundamental() {
        return espEjaFundamental;
    }

    public boolean isEspEjaMedio() {
        return espEjaMedio;
    }

    public boolean isEnsinoEja() {
        return ensinoEja;
    }

    public boolean isEjaFundamental() {
        return ejaFundamental;
    }

    public boolean isEjaMedio() {
        return ejaMedio;
    }

    public boolean isEjaProjovem() {
        return ejaProjovem;
    }

    public double getIdebAI() {
        return idebAI;
    }

    public double getIdebAF() {
        return idebAF;
    }

    public double getEnemMediaGeral() {
        return enemMediaGeral;
    }

    public double getEnemMediaObjetiva() {
        return enemMediaObjetiva;
    }

    public double getFormacaoDocente() {
        return formacaoDocente;
    }

    public void setAnoCenso(int anoCenso) {
        this.anoCenso = anoCenso;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public void setSituacaoFuncionamento(int situacaoFuncionamento) {
        this.situacaoFuncionamento = situacaoFuncionamento;
    }

    public void setSituacaoCenso(int situacaoCenso) {
        this.situacaoCenso = situacaoCenso;
    }

    public void setCodUf(int codUf) {
        this.codUf = codUf;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public void setCodDistrito(int codDistrito) {
        this.codDistrito = codDistrito;
    }

    public void setTipoLocalizacao(int tipoLocalizacao) {
        this.tipoLocalizacao = tipoLocalizacao;
    }

    public void setRegulamentada(int regulamentada) {
        this.regulamentada = regulamentada;
    }

    public void setSalasExistentes(int salasExistentes) {
        this.salasExistentes = salasExistentes;
    }

    public void setSalasUtilizadas(int salasUtilizadas) {
        this.salasUtilizadas = salasUtilizadas;
    }

    public void setTelevisores(int televisores) {
        this.televisores = televisores;
    }

    public void setVideoCassetes(int videoCassetes) {
        this.videoCassetes = videoCassetes;
    }

    public void setDvds(int dvds) {
        this.dvds = dvds;
    }

    public void setParabolicas(int parabolicas) {
        this.parabolicas = parabolicas;
    }

    public void setAparelhosSom(int aparelhosSom) {
        this.aparelhosSom = aparelhosSom;
    }

    public void setDatashows(int datashows) {
        this.datashows = datashows;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setComputadores(int computadores) {
        this.computadores = computadores;
    }

    public void setComputadoresAdm(int computadoresAdm) {
        this.computadoresAdm = computadoresAdm;
    }

    public void setComputadoresAlunos(int computadoresAlunos) {
        this.computadoresAlunos = computadoresAlunos;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setCopiadoras(int copiadoras) {
        this.copiadoras = copiadoras;
    }

    public void setRetroprojetores(int retroprojetores) {
        this.retroprojetores = retroprojetores;
    }

    public void setImpressoras(int impressoras) {
        this.impressoras = impressoras;
    }

    public void setAtividadeComplementar(int atividadeComplementar) {
        this.atividadeComplementar = atividadeComplementar;
    }

    public void setSocioEconomico(int socioEconomico) {
        this.socioEconomico = socioEconomico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setDependenciaAdministrativa(int dependenciaAdministrativa) {
        this.dependenciaAdministrativa = dependenciaAdministrativa;
    }

    public void setSituacaoFuncionamentoTxt(String situacaoFuncionamentoTxt) {
        this.situacaoFuncionamentoTxt = situacaoFuncionamentoTxt;
    }

    public void setDependenciaAdministrativaTxt(String dependenciaAdministrativaTxt) {
        this.dependenciaAdministrativaTxt = dependenciaAdministrativaTxt;
    }

    public void setInicioAno(String inicioAno) {
        this.inicioAno = inicioAno;
    }

    public void setFimAno(String fimAno) {
        this.fimAno = fimAno;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public void setNomeDistrito(String nomeDistrito) {
        this.nomeDistrito = nomeDistrito;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public void setInicioAnoTxt(String inicioAnoTxt) {
        this.inicioAnoTxt = inicioAnoTxt;
    }

    public void setFimAnoTxt(String fimAnoTxt) {
        this.fimAnoTxt = fimAnoTxt;
    }

    public void setTipoLocalizacaoTxt(String tipoLocalizacaoTxt) {
        this.tipoLocalizacaoTxt = tipoLocalizacaoTxt;
    }

    public void setRegulamentadaTxt(String regulamentadaTxt) {
        this.regulamentadaTxt = regulamentadaTxt;
    }

    public void setAguaCacimba(boolean aguaCacimba) {
        this.aguaCacimba = aguaCacimba;
    }

    public void setAguaFiltrada(boolean aguaFiltrada) {
        this.aguaFiltrada = aguaFiltrada;
    }

    public void setAguaInexistente(boolean aguaInexistente) {
        this.aguaInexistente = aguaInexistente;
    }

    public void setAguaPocoArtesiano(boolean aguaPocoArtesiano) {
        this.aguaPocoArtesiano = aguaPocoArtesiano;
    }

    public void setAguaPublica(boolean aguaPublica) {
        this.aguaPublica = aguaPublica;
    }

    public void setAguaRio(boolean aguaRio) {
        this.aguaRio = aguaRio;
    }

    public void setAlmoxarifado(boolean almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public void setEnergiaPublica(boolean energiaPublica) {
        this.energiaPublica = energiaPublica;
    }

    public void setEnergiaGerador(boolean energiaGerador) {
        this.energiaGerador = energiaGerador;
    }

    public void setEnergiaOutros(boolean energiaOutros) {
        this.energiaOutros = energiaOutros;
    }

    public void setEnergiaInexistente(boolean energiaInexistente) {
        this.energiaInexistente = energiaInexistente;
    }

    public void setEsgotoPublico(boolean esgotoPublico) {
        this.esgotoPublico = esgotoPublico;
    }

    public void setEsgotoFossa(boolean esgotoFossa) {
        this.esgotoFossa = esgotoFossa;
    }

    public void setEsgotoInexistente(boolean esgotoInexistente) {
        this.esgotoInexistente = esgotoInexistente;
    }

    public void setLixoColetaPeriodica(boolean lixoColetaPeriodica) {
        this.lixoColetaPeriodica = lixoColetaPeriodica;
    }

    public void setLixoQueima(boolean lixoQueima) {
        this.lixoQueima = lixoQueima;
    }

    public void setLixoJogaOutraArea(boolean lixoJogaOutraArea) {
        this.lixoJogaOutraArea = lixoJogaOutraArea;
    }

    public void setLixoRecicla(boolean lixoRecicla) {
        this.lixoRecicla = lixoRecicla;
    }

    public void setLixoEnterra(boolean lixoEnterra) {
        this.lixoEnterra = lixoEnterra;
    }

    public void setLixoOutros(boolean lixoOutros) {
        this.lixoOutros = lixoOutros;
    }

    public void setSalaDiretoria(boolean salaDiretoria) {
        this.salaDiretoria = salaDiretoria;
    }

    public void setSalaProfessores(boolean salaProfessores) {
        this.salaProfessores = salaProfessores;
    }

    public void setLaboratorioInformatica(boolean laboratorioInformatica) {
        this.laboratorioInformatica = laboratorioInformatica;
    }

    public void setLaboratorioCiencias(boolean laboratorioCiencias) {
        this.laboratorioCiencias = laboratorioCiencias;
    }

    public void setAtendimentoEspecial(boolean atendimentoEspecial) {
        this.atendimentoEspecial = atendimentoEspecial;
    }

    public void setQuadraCoberta(boolean quadraCoberta) {
        this.quadraCoberta = quadraCoberta;
    }

    public void setQuadraDescoberta(boolean quadraDescoberta) {
        this.quadraDescoberta = quadraDescoberta;
    }

    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }

    public void setBiblioteca(boolean biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void setSalaLeitura(boolean salaLeitura) {
        this.salaLeitura = salaLeitura;
    }

    public void setParqueInfantil(boolean parqueInfantil) {
        this.parqueInfantil = parqueInfantil;
    }

    public void setBercario(boolean bercario) {
        this.bercario = bercario;
    }

    public void setSanitarioForaPredio(boolean sanitarioForaPredio) {
        this.sanitarioForaPredio = sanitarioForaPredio;
    }

    public void setSanitarioDentroPredio(boolean sanitarioDentroPredio) {
        this.sanitarioDentroPredio = sanitarioDentroPredio;
    }

    public void setSanitarioEducInfant(boolean sanitarioEducInfant) {
        this.sanitarioEducInfant = sanitarioEducInfant;
    }

    public void setSanitarioPNE(boolean sanitarioPNE) {
        this.sanitarioPNE = sanitarioPNE;
    }

    public void setDependenciasPNE(boolean dependenciasPNE) {
        this.dependenciasPNE = dependenciasPNE;
    }

    public void setSecretaria(boolean secretaria) {
        this.secretaria = secretaria;
    }

    public void setBanheiroChuveiro(boolean banheiroChuveiro) {
        this.banheiroChuveiro = banheiroChuveiro;
    }

    public void setRefeitorio(boolean refeitorio) {
        this.refeitorio = refeitorio;
    }

    public void setDespensa(boolean despensa) {
        this.despensa = despensa;
    }

    public void setAuditorio(boolean auditorio) {
        this.auditorio = auditorio;
    }

    public void setPatioCoberto(boolean patioCoberto) {
        this.patioCoberto = patioCoberto;
    }

    public void setPatioDescoberto(boolean patioDescoberto) {
        this.patioDescoberto = patioDescoberto;
    }

    public void setAlojamentoAluno(boolean alojamentoAluno) {
        this.alojamentoAluno = alojamentoAluno;
    }

    public void setAlojamentoProfessor(boolean alojamentoProfessor) {
        this.alojamentoProfessor = alojamentoProfessor;
    }

    public void setAreaVerde(boolean areaVerde) {
        this.areaVerde = areaVerde;
    }

    public void setLavanderia(boolean lavanderia) {
        this.lavanderia = lavanderia;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public void setBandaLarga(boolean bandaLarga) {
        this.bandaLarga = bandaLarga;
    }

    public void setAlimentacao(boolean alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setAee(boolean aee) {
        this.aee = aee;
    }

    public void setEnsinoRegular(boolean ensinoRegular) {
        this.ensinoRegular = ensinoRegular;
    }

    public void setRegCreche(boolean regCreche) {
        this.regCreche = regCreche;
    }

    public void setRegPreescola(boolean regPreescola) {
        this.regPreescola = regPreescola;
    }

    public void setRegFundamental8(boolean regFundamental8) {
        this.regFundamental8 = regFundamental8;
    }

    public void setRegFundamental9(boolean regFundamental9) {
        this.regFundamental9 = regFundamental9;
    }

    public void setRegMedioMedio(boolean regMedioMedio) {
        this.regMedioMedio = regMedioMedio;
    }

    public void setRegMedioIntegrado(boolean regMedioIntegrado) {
        this.regMedioIntegrado = regMedioIntegrado;
    }

    public void setRegMedioNormal(boolean regMedioNormal) {
        this.regMedioNormal = regMedioNormal;
    }

    public void setRegMedioProfissional(boolean regMedioProfissional) {
        this.regMedioProfissional = regMedioProfissional;
    }

    public void setEnsinoEspecial(boolean ensinoEspecial) {
        this.ensinoEspecial = ensinoEspecial;
    }

    public void setEspCreche(boolean espCreche) {
        this.espCreche = espCreche;
    }

    public void setEspPreescola(boolean espPreescola) {
        this.espPreescola = espPreescola;
    }

    public void setEspFundamental8(boolean espFundamental8) {
        this.espFundamental8 = espFundamental8;
    }

    public void setEspFundamental9(boolean espFundamental9) {
        this.espFundamental9 = espFundamental9;
    }

    public void setEspMedioMedio(boolean espMedioMedio) {
        this.espMedioMedio = espMedioMedio;
    }

    public void setEspMedioIntegrado(boolean espMedioIntegrado) {
        this.espMedioIntegrado = espMedioIntegrado;
    }

    public void setEspMedioNormal(boolean espMedioNormal) {
        this.espMedioNormal = espMedioNormal;
    }

    public void setEspMedioProfissional(boolean espMedioProfissional) {
        this.espMedioProfissional = espMedioProfissional;
    }

    public void setEspEjaFundamental(boolean espEjaFundamental) {
        this.espEjaFundamental = espEjaFundamental;
    }

    public void setEspEjaMedio(boolean espEjaMedio) {
        this.espEjaMedio = espEjaMedio;
    }

    public void setEnsinoEja(boolean ensinoEja) {
        this.ensinoEja = ensinoEja;
    }

    public void setEjaFundamental(boolean ejaFundamental) {
        this.ejaFundamental = ejaFundamental;
    }

    public void setEjaMedio(boolean ejaMedio) {
        this.ejaMedio = ejaMedio;
    }

    public void setEjaProjovem(boolean ejaProjovem) {
        this.ejaProjovem = ejaProjovem;
    }

    public void setIdebAI(double idebAI) {
        this.idebAI = idebAI;
    }

    public void setIdebAF(double idebAF) {
        this.idebAF = idebAF;
    }

    public void setEnemMediaGeral(double enemMediaGeral) {
        this.enemMediaGeral = enemMediaGeral;
    }

    public void setEnemMediaObjetiva(double enemMediaObjetiva) {
        this.enemMediaObjetiva = enemMediaObjetiva;
    }

    public void setFormacaoDocente(double formacaoDocente) {
        this.formacaoDocente = formacaoDocente;
    }



}
