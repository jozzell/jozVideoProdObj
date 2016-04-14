/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.eNum;

/**
 *
 * @author lmeans
 */
public enum eNumVideoIDs {
    Adds(210,"Jozzell Video Production"),
    // -------------------------------------------------------
    VOI22nd(203,"22nd Anniversary (2011)"  ),
    VOI23nd(204,"23rd Anniversary (2012)"),
    VOI24nd(205,"24th Anniversary (2013)"),
    VOI25nd(99,"25th Anniversary (2014) Brooklyn Marriott"),
    VOI26nd(98,"26th Anniversary (2015)"),
    // ------------------------------------------
    Anaysha(202,"Jozzell Video Production",true),
    MrClean(200,"Jozzell Video Production"),
    MsRucker(201,"Jozzell Video Production",true),
    // ------------------------------------------
    CommunityAwardCeremony(104,"Jozzell Video Production"),
    CommunityPicnic(103,"Jozzell Video Production"),
    EventsRedCarpet(105,"Jozzell Video Production"),
    // ------------------------------------------
    VideoSweet16(100,"Jozzell Video Production",true),
    Events(101,"Events"),
    VideoSportsGame(106,"Football (Full Game)"),
    VideoSports(102,"Football (Highlight Real)"),
     // ----------------------------------------------------------
    ShirleyPublicAccess(108,"Jozzell Video Production",true),
    HearAndNow(107,"Jozzell Video Production",true),
    SpinMain(206,"Jozzell Video Production",true),
    SpinBonus(208,"Jozzell Video Production",true),
    Leone(207,"Jozzell Video Production",true),
    // ---------------------------------------------------------
    MountOlive(1105, "cal/church_mtolive.xhtml"),
    FirstBaptist2009(1206, "Gospel Concert (2010)",1),
    FirstBaptist(1106, "Royal Priesthool (Anniversary)",1),
    FirstBaptistEvolution(1121,"The Evolution of Gospel Music"),
    EOC(1107, "cal/church_EOC.xhtml"),
    TrackClubAlumni(1115,"Alumni",1),
    TrackClubAAU(1114,"Baldwin Blazers (AAU)",1),
    TrackClubOutdoor(1113,"Baldwin Blazers (Outdoor)",1),
    TrackClubIndoor(97,"Baldwin Blazers (Indoor)",1),
    BeerScott(1116,"Scott Pereira",1),
    BeerHomebrews(1117,"Homebrews and Handgrenades",1),
    BeerHicksvill(1118,"Hicksville Beer & Soda",1),
    BeerLNB(1119,"Little Neck Beverag",1);;
    // --------------------------------------------------------------
    private final String title;
    private final int id,brwDisplayType;
    private boolean single;
    private eNumVideoIDs(int id,String title,boolean single,int brwType){
        this.title = title;
        this.id = id;
        this.single = single;
        this.brwDisplayType = brwType;
    }
    private eNumVideoIDs(int id,String title,boolean single){
        this(id,title,single,0);
    }
    private eNumVideoIDs(int id,String title){
        this(id,title,false,0);
    }
    private eNumVideoIDs(int id,String title,int type){
        this(id,title,false,type);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the single
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * @return the brwDisplayType
     */
    public int getBrwDisplayType() {
        return brwDisplayType;
    }
}
