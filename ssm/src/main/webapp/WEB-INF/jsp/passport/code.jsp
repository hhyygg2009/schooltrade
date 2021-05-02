<%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" pageEncoding="gbk" %>
<%@ page import="java.io.OutputStream" %>

<%--	采用JPG格式的图片验证码	--%>

<%!
    Color getRandColor()    //随机生成图片中rgb的值
    {
        int r, g, b;
        Random random = new Random();
        r = random.nextInt(155);
        g = random.nextInt(155);
        b = random.nextInt(155);
        return new Color(r + 100, g + 100, b + 100);
    }
%>

<%
    int w, h;
    w = 70;
    h = 30;
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    OutputStream os = response.getOutputStream();
    String rands = "";
    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    Random r = new Random();
    Color basecolor = new Color(0, 0, 0);
    g.setColor(basecolor);
    g.fillRect(0, 0, w, h);

    for (int i = 0; i < 4; i++) {

        g.setColor(getRandColor());
        g.drawLine(r.nextInt(w), r.nextInt(h), r.nextInt(w), r.nextInt(h));
    }

    for (int i = 0; i < 4; i++) {
        String rand = String.valueOf(r.nextInt(10));
        rands += rand;
        g.setColor(getRandColor());
        g.drawString(rand, i * 14 + 5, 15);
    }

    session.setAttribute("captcha", rands);
    ImageIO.write(image, "jpeg", os);
    os.flush();
    os.close();

    out.clear();
    out = pageContext.pushBody();


%>