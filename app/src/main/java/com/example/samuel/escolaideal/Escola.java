package com.example.samuel.escolaideal;

import java.util.HashMap;

public class Escola {
    private HashMap<String, Object> chaves = new HashMap<String, Object>();
    private int cod,codCidade;
    private String estado,regiao,situacaoFuncionamentoTxt,dependenciaAdministrativaTxt;
            private double idebAI,idebAF;

    public Escola() {    }

    public Escola(String estado,String regiao,String situacaoFuncionamentoTxt,String dependenciaAdministrativaTxt,int cod,int codCidade,double idebAF,double idebAI,String nome, String nomeMunicipio, String latitude, String longitude, int tipoLocalizacao, int anoSenso, int situacaoFuncionamento, int dependenciaAdministrativa, boolean laboratorioInformatica, boolean laboratorioCiencias, boolean biblioteca, boolean bandLarga, boolean aguaPublica, boolean aguaInexistente, boolean energiaPublica, boolean esgotoPublico, boolean esgotoInexistente, boolean sanitarioPNE, boolean depenciasPNE, boolean regCreche, boolean regFundamental8, boolean regFundamental9, boolean regMedioMedio, boolean regMedioIntegrado, boolean regMedioNormal, boolean regMedioProfissional, double enemPortugues, double enemMatematica, double enemHumanas, double enemNaturais, double enemRedacao, double enemMediaObjetiva, double enemMediaGeral) {

    }


    public int getCod() {
        return (int) chaves.get("cod");
    }

    public void setCod(int cod) {
        chaves.put("cod", cod);
    }

    public int getCodCidade() {
        return (int) chaves.get("codCidade");
    }

    public void setCodCidade(int codCidade) {
        chaves.put("codCidade", codCidade);
    }

    public String getEstado() {
        return (String) chaves.get("estado");
    }

    public void setEstado(String estado) {
        chaves.put("estado", estado);
    }

    public String getRegiao() {
        return (String) chaves.get("regiao");
    }

    public void setRegiao(String regiao) {
        chaves.put("regiao", regiao);
    }

    public String getSituacaoFuncionamentoTxt() {
        return (String) chaves.get("situacaoFuncionamentoTxt");
    }

    public void setSituacaoFuncionamentoTxt(String situacaoFuncionamentoTxt) {
        chaves.put("situacaoFuncionamentoTxt", situacaoFuncionamentoTxt);
    }

    public String getDependenciaAdministrativaTxt() {
        return (String) chaves.get("dependenciaAdministrativaTxt");
    }

    public void setDependenciaAdministrativaTxt(String dependenciaAdministrativaTxt) {
        chaves.put("dependenciaAdministrativaTxt", dependenciaAdministrativaTxt);
    }

    public double getIdebAI() {
        return (double) chaves.get("idebAI");
    }

    public void setIdebAI(double idebAI) {
        chaves.put("idebAI", idebAI);
    }

    public double getIdebAF() {
        return (double) chaves.get("idebAF");
    }

    public void setIdebAF(double idebAF) {
        chaves.put("idebAF", idebAF);
    }

    public void setValues(String chave, Object value){
        chaves.put(chave,value);

    }


    public String getNome() { return (String) chaves.get("nome");
    }

    public void setNome(String nome) {
        chaves.put("nome", nome);
    }

    public String getNomeMunicipio() {
        return (String) chaves.get("nomeMunicipio");
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        chaves.put("nomeMunicipio", nomeMunicipio);
    }

    public String getLatitude() {
        return (String) chaves.get("latitude");
    }

    public void setLatitude(String latitude) {
        chaves.put("latitude", latitude);
    }

    public String getLongitude() {
        return (String) chaves.get("longitude");
    }

    public void setLongitude(String longitude) {
        chaves.put("longitude", longitude);
    }

    public int getTipoLocalizacao() {
        return (int) chaves.get("tipoLocalizacao");
    }

    public void setTipoLocalizacao(int tipoLocalizacao) {
        chaves.put("tipoLocalizacao", tipoLocalizacao);
    }

    public int getAnoSenso() {
        return (int) chaves.get("anoSenso");
    }

    public void setAnoSenso(int anoSenso) {
        chaves.put("anoSenso", anoSenso);
    }

    public int getSituacaoFuncionamento() {
        return (int) chaves.get("situacaoFuncionamento");
    }

    public void setSituacaoFuncionamento(int situacaoFuncionamento) {
        chaves.put("situacaoFuncionamento", situacaoFuncionamento);
    }

    public int getDependenciaAdministrativa() {
        return (int) chaves.get("dependenciaAdministrativa");
    }

    public void setDependenciaAdministrativa(int dependenciaAdministrativa) {
        chaves.put("dependenciaAdministrativa", dependenciaAdministrativa);
    }

    public boolean isLaboratorioInformatica() {
        return (boolean) chaves.get("laboratorioInformatica");
    }

    public void setLaboratorioInformatica(boolean laboratorioInformatica) {
        chaves.put("laboratorioInformatica", laboratorioInformatica);
    }

    public boolean isLaboratorioCiencias() {
        return (boolean) chaves.get("laboratorioCiencias");
    }

    public void setLaboratorioCiencias(boolean laboratorioCiencias) {
        chaves.put("laboratorioCiencias", laboratorioCiencias);
    }

    public boolean isBiblioteca() {
        return (boolean) chaves.get("biblioteca");
    }

    public void setBiblioteca(boolean biblioteca) {
        chaves.put("biblioteca", biblioteca);
    }

    public boolean isBandLarga() {
        return (boolean) chaves.get("bandLarga");
    }

    public void setBandLarga(boolean bandLarga) {
        chaves.put("bandLarga", bandLarga);
    }

    public boolean isAguaPublica() {
        return (boolean) chaves.get("aguaPublica");
    }

    public void setAguaPublica(boolean aguaPublica) {
        chaves.put("aguaPublica", aguaPublica);
    }

    public boolean isAguaInexistente() {
        return (boolean) chaves.get("aguaInexistente");
    }

    public void setAguaInexistente(boolean aguaInexistente) {
        chaves.put("aguaInexistente", aguaInexistente);
    }

    public boolean isEnergiaPublica() {
        return (boolean) chaves.get("energiaPublica");
    }

    public void setEnergiaPublica(boolean energiaPublica) {
        chaves.put("energiaPublica", energiaPublica);
    }

    public boolean isEsgotoPublico() {
        return (boolean) chaves.get("esgotoPublico");
    }

    public void setEsgotoPublico(boolean esgotoPublico) {
        chaves.put("esgotoPublico", esgotoPublico);
    }

    public boolean isEsgotoInexistente() {
        return (boolean) chaves.get("esgotoInexistente");
    }

    public void setEsgotoInexistente(boolean esgotoInexistente) {
        chaves.put("esgotoInexistente", esgotoInexistente);
    }

    public boolean isSanitarioPNE() {
        return (boolean) chaves.get("sanitarioPNE");
    }

    public void setSanitarioPNE(boolean sanitarioPNE) {
        chaves.put("sanitarioPNE", sanitarioPNE);
    }

    public boolean isDepenciasPNE() {
        return (boolean) chaves.get("depenciasPNE");
    }

    public void setDepenciasPNE(boolean depenciasPNE) {
        chaves.put("depenciasPNE", depenciasPNE);
    }

    public boolean isRegCreche() {
        return (boolean) chaves.get("regCreche");
    }

    public void setRegCreche(boolean regCreche) {
        chaves.put("regCreche", regCreche);
    }

    public boolean isRegFundamental8() {
        return (boolean) chaves.get("regFundamental8");
    }

    public void setRegFundamental8(boolean regFundamental8) {
        chaves.put("regFundamental8", regFundamental8);
    }

    public boolean isRegFundamental9() {
        return (boolean) chaves.get("regFundamental9");
    }

    public void setRegFundamental9(boolean regFundamental9) {
        chaves.put("regFundamental9", regFundamental9);
    }

    public boolean isRegMedioMedio() {
        return (boolean) chaves.get("regMedioMedio");
    }

    public void setRegMedioMedio(boolean regMedioMedio) {
        chaves.put("regMedioMedio", regMedioMedio);
    }

    public boolean isRegMedioIntegrado() {
        return (boolean) chaves.get("regMedioIntegrado");
    }

    public void setRegMedioIntegrado(boolean regMedioIntegrado) {
        chaves.put("regMedioIntegrado", regMedioIntegrado);
    }

    public boolean isRegMedioNormal() {
        return (boolean) chaves.get("regMedioNormal");
    }

    public void setRegMedioNormal(boolean regMedioNormal) {
        chaves.put("regMedioNormal", regMedioNormal);
    }

    public boolean isRegMedioProfissional() {
        return (boolean) chaves.get("regMedioProfissional");
    }

    public void setRegMedioProfissional(boolean regMedioProfissional) {
        chaves.put("regMedioProfissional", regMedioProfissional);
    }

    public double getEnemPortugues() {
        return (double) chaves.get("enemPortugues");
    }

    public void setEnemPortugues(double enemPortugues) {
        chaves.put("enemPortugues", enemPortugues);
    }

    public double getEnemMatematica() {
        return (double) chaves.get("enemMatematica");
    }

    public void setEnemMatematica(double enemMatematica) {
        chaves.put("enemMatematica", enemMatematica);
    }

    public double getEnemHumanas() {
        return (double) chaves.get("enemHumanas");
    }

    public void setEnemHumanas(double enemHumanas) {
        chaves.put("enemHumanas", enemHumanas);
    }

    public double getEnemNaturais() {
        return (double) chaves.get("enemNaturais");
    }

    public void setEnemNaturais(double enemNaturais) {
        chaves.put("enemNaturais", enemNaturais);
    }

    public double getEnemRedacao() {
        return (double) chaves.get("enemRedacao");
    }

    public void setEnemRedacao(double enemRedacao) {
        chaves.put("enemRedacao", enemRedacao);
    }

    public double getEnemMediaObjetiva() {
        return (double) chaves.get("enemMediaObjetiva");
    }

    public void setEnemMediaObjetiva(double enemMediaObjetiva) {
        chaves.put("enemMediaObjetiva", enemMediaObjetiva);
    }

    public double getEnemMediaGeral() {
        return (double) chaves.get("enemMediaGeral");
    }

    public void setEnemMediaGeral(double enemMediaGeral) {
        chaves.put("enemMediaGeral", enemMediaGeral);
    }


}
