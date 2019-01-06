package petrossov.Models;

public class Product {

    private Integer id;
    private String name;
    private Integer laminat;
    private Integer mdf;
    private Integer tableTop;
    private Integer arm;
    private Integer leg;
    private Integer extensionSystem;
    private Integer loop;
    private Integer sink;
    private Integer fastener;
    private Integer additional;
    private Integer productPrice;

    public Product() {
    }

    public Product(String name, Integer laminat, Integer mdf, Integer tableTop,
                   Integer arm, Integer leg, Integer extensionSystem,
                   Integer loop, Integer sink, Integer fastener, Integer additional,
                   Integer productPrice ) {
        this.name = name;
        this.laminat = laminat;
        this.mdf = mdf;
        this.tableTop = tableTop;
        this.arm = arm;
        this.leg = leg;
        this.extensionSystem = extensionSystem;
        this.loop = loop;
        this.sink = sink;
        this.fastener = fastener;
        this.additional = additional;
        this.productPrice = productPrice;
    }
    public Product(Integer id, String name, Integer laminat, Integer mdf, Integer tableTop,
                   Integer arm, Integer leg, Integer extensionSystem,
                   Integer loop, Integer sink, Integer fastener, Integer additional,
                   Integer productPrice ) {
        this.id = id;
        this.name = name;
        this.laminat = laminat;
        this.mdf = mdf;
        this.tableTop = tableTop;
        this.arm = arm;
        this.leg = leg;
        this.extensionSystem = extensionSystem;
        this.loop = loop;
        this.sink = sink;
        this.fastener = fastener;
        this.additional = additional;
        this.productPrice = productPrice;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLaminat() {
        return laminat;
    }

    public void setLaminat(Integer laminat) {
        this.laminat = laminat;
    }

    public Integer getMdf() {
        return mdf;
    }

    public void setMdf(Integer mdf) {
        this.mdf = mdf;
    }

    public Integer getTableTop() {
        return tableTop;
    }

    public void setTableTop(Integer tableTop) {
        this.tableTop = tableTop;
    }

    public Integer getArm() {
        return arm;
    }

    public void setArm(Integer arm) {
        this.arm = arm;
    }

    public Integer getLeg() {
        return leg;
    }

    public void setLeg(Integer leg) {
        this.leg = leg;
    }

    public Integer getExtensionSystem() {
        return extensionSystem;
    }

    public void setExtensionSystem(Integer extensionSystem) {
        this.extensionSystem = extensionSystem;
    }

    public Integer getLoop() {
        return loop;
    }

    public void setLoop(Integer loop) {
        this.loop = loop;
    }

    public Integer getSink() {
        return sink;
    }

    public void setSink(Integer sink) {
        this.sink = sink;
    }

    public Integer getFastener() {
        return fastener;
    }

    public void setFastener(Integer fastener) {
        this.fastener = fastener;
    }

    public Integer getAdditional() {
        return additional;
    }

    public void setAdditional(Integer additional) {
        this.additional = additional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laminat=" + laminat +
                ", mdf=" + mdf +
                ", tableTop=" + tableTop +
                ", arm=" + arm +
                ", leg=" + leg +
                ", extensionSystem=" + extensionSystem +
                ", loop=" + loop +
                ", sink=" + sink +
                ", fastener=" + fastener +
                ", additional=" + additional +
                ", productPrice=" + productPrice +
                '}';
    }

    public Integer calculateProductCost(Product product){
        this.productPrice = ((product.getLaminat()*10000) + (product.getMdf()*10000)
                +(product.getTableTop()*15000) + (product.getArm()*500)
                +(product.getLeg()*500) + (product.getExtensionSystem()*800)
                +(product.getLoop()*100) + (product.getSink()*500)
                +(product.getFastener()*5000) + (product.getAdditional()*5000))*2;
        return productPrice;
    }
}
