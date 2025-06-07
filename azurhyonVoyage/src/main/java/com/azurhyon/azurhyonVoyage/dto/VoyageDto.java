package com.azurhyon.azurhyonVoyage.dto;

public class VoyageDto {
	
	private MeteoDto meteo = new MeteoDto();
	private RouteDto route = new RouteDto();
	private int orientation = 0;
	private String succesOrientation = "";
	private int survie = 0;
	private BashDto bash = new BashDto();
	private LieuDto lieu1 = new LieuDto(0,0);
	private LieuDto lieu2 = new LieuDto(0,0);
	private int vitesse = 0;
	private int tempsMarche = 0;
	private EvenementDto evnmt1 = new EvenementDto(0,0);
	private EvenementDto evnmt2 = new EvenementDto(0,0);
	private int renseignement = 0;
	private LogementDto logement = new LogementDto();
	
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public MeteoDto getMeteo() {
		return meteo;
	}
	public void setMeteo(MeteoDto meteo) {
		this.meteo = meteo;
	}
	public RouteDto getRoute() {
		return route;
	}
	public void setRoute(RouteDto route) {
		this.route = route;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public int getSurvie() {
		return survie;
	}
	public void setSurvie(int survie) {
		this.survie = survie;
	}
	public BashDto getBash() {
		return bash;
	}
	public void setBash(BashDto bash) {
		this.bash = bash;
	}
	public String getSuccesOrientation() {
		return succesOrientation;
	}
	public void setSuccesOrientation(String succesOrientation) {
		this.succesOrientation = succesOrientation;
	}
	public LieuDto getLieu1() {
		return lieu1;
	}
	public void setLieu1(LieuDto lieu1) {
		this.lieu1 = lieu1;
	}
	public LieuDto getLieu2() {
		return lieu2;
	}
	public void setLieu2(LieuDto lieu2) {
		this.lieu2 = lieu2;
	}
	public int getTempsMarche() {
		return tempsMarche;
	}
	public void setTempsMarche(int tempsMarche) {
		this.tempsMarche = tempsMarche;
	}
	public EvenementDto getEvnmt1() {
		return evnmt1;
	}
	public void setEvnmt1(EvenementDto evnmt1) {
		this.evnmt1 = evnmt1;
	}
	public EvenementDto getEvnmt2() {
		return evnmt2;
	}
	public void setEvnmt2(EvenementDto evnmt2) {
		this.evnmt2 = evnmt2;
	}
	public int getRenseignement() {
		return renseignement;
	}
	public void setRenseignement(int renseignement) {
		this.renseignement = renseignement;
	}
	public LogementDto getLogement() {
		return logement;
	}
	public void setLogement(LogementDto logement) {
		this.logement = logement;
	}

}
