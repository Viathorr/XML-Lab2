<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:key name="candiesByType" match="Candy" use="Type"/>

    <xsl:template match="Candies">
        <xsl:text>
</xsl:text>
        <Candies>
            <xsl:for-each select="Candy[generate-id()=generate-id(key('candiesByType', Type)[1])]">
                <xsl:element name="{Type}">
                    <xsl:for-each select="key('candiesByType', Type)">
                        <xsl:copy-of select="."/>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each>
        </Candies>
    </xsl:template>

</xsl:stylesheet>