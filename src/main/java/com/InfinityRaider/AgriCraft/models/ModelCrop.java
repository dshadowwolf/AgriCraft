package com.InfinityRaider.AgriCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrop extends ModelBase {
    public ModelCrop() {
        Stick1 = new ModelRenderer(this, 0, 0);
        Stick1.addBox(0F, 0F, 0F, 1, 13, 1, 0F);
        Stick1.setRotationPoint(5F, 11F, -6F);
        Stick1.rotateAngleX = 0F;
        Stick1.rotateAngleY = 0F;
        Stick1.rotateAngleZ = 0F;
        Stick1.mirror = false;
        Stick2 = new ModelRenderer(this, 0, 0);
        Stick2.addBox(0F, 0F, 0F, 1, 13, 1, 0F);
        Stick2.setRotationPoint(-6F, 11F, -6F);
        Stick2.rotateAngleX = 0F;
        Stick2.rotateAngleY = 0F;
        Stick2.rotateAngleZ = 0F;
        Stick2.mirror = false;
        Stick3 = new ModelRenderer(this, 0, 0);
        Stick3.addBox(0F, 0F, 0F, 1, 13, 1, 0F);
        Stick3.setRotationPoint(-6F, 11F, 5F);
        Stick3.rotateAngleX = 0F;
        Stick3.rotateAngleY = 0F;
        Stick3.rotateAngleZ = 0F;
        Stick3.mirror = false;
        Stick4 = new ModelRenderer(this, 0, 0);
        Stick4.addBox(0F, 0F, 0F, 1, 13, 1, 0F);
        Stick4.setRotationPoint(5F, 11F, 5F);
        Stick4.rotateAngleX = 0F;
        Stick4.rotateAngleY = 0F;
        Stick4.rotateAngleZ = 0F;
        Stick4.mirror = false;
        CrossBar1 = new ModelRenderer(this, 0, 27);
        CrossBar1.addBox(0F, 0F, 0F, 10, 1, 1, 0F);
        CrossBar1.setRotationPoint(-5F, 13F, -6F);
        CrossBar1.rotateAngleX = 0F;
        CrossBar1.rotateAngleY = 0F;
        CrossBar1.rotateAngleZ = 0F;
        CrossBar1.mirror = false;
        CrossBar2 = new ModelRenderer(this, 0, 27);
        CrossBar2.addBox(9F, 0F, -2F, 10, 1, 1, 0F);
        CrossBar2.setRotationPoint(-14F, 13F, 7F);
        CrossBar2.rotateAngleX = 0F;
        CrossBar2.rotateAngleY = 0F;
        CrossBar2.rotateAngleZ = 0F;
        CrossBar2.mirror = false;
        CrossBar3 = new ModelRenderer(this, 0, 15);
        CrossBar3.addBox(0F, 0F, 0F, 1, 1, 10, 0F);
        CrossBar3.setRotationPoint(5F, 13F, -5F);
        CrossBar3.rotateAngleX = 0F;
        CrossBar3.rotateAngleY = 0F;
        CrossBar3.rotateAngleZ = 0F;
        CrossBar3.mirror = false;
        CrossBar4 = new ModelRenderer(this, 0, 15);
        CrossBar4.addBox(0F, 0F, 0F, 1, 1, 10, 0F);
        CrossBar4.setRotationPoint(-6F, 13F, -5F);
        CrossBar4.rotateAngleX = 0F;
        CrossBar4.rotateAngleY = 0F;
        CrossBar4.rotateAngleZ = 0F;
        CrossBar4.mirror = false;
        xnotch1 = new ModelRenderer(this, 5, 0);
        xnotch1.addBox(0F, 0F, 0F, 2, 1, 1, 0F);
        xnotch1.setRotationPoint(6F, 13F, -6F);
        xnotch1.rotateAngleX = 0F;
        xnotch1.rotateAngleY = 0F;
        xnotch1.rotateAngleZ = 0F;
        xnotch1.mirror = false;
        xnotch2 = new ModelRenderer(this, 5, 0);
        xnotch2.addBox(0F, 0F, 0F, 2, 1, 1, 0F);
        xnotch2.setRotationPoint(-8F, 13F, -6F);
        xnotch2.rotateAngleX = 0F;
        xnotch2.rotateAngleY = 0F;
        xnotch2.rotateAngleZ = 0F;
        xnotch2.mirror = false;
        xnotch3 = new ModelRenderer(this, 5, 0);
        xnotch3.addBox(0F, 13F, 5F, 2, 1, 1, 0F);
        xnotch3.setRotationPoint(6F, 0F, 0F);
        xnotch3.rotateAngleX = 0F;
        xnotch3.rotateAngleY = 0F;
        xnotch3.rotateAngleZ = 0F;
        xnotch3.mirror = false;
        xnotch4 = new ModelRenderer(this, 5, 0);
        xnotch4.addBox(0F, 0F, 0F, 2, 1, 1, 0F);
        xnotch4.setRotationPoint(-8F, 13F, 5F);
        xnotch4.rotateAngleX = 0F;
        xnotch4.rotateAngleY = 0F;
        xnotch4.rotateAngleZ = 0F;
        xnotch4.mirror = false;
        znotch1 = new ModelRenderer(this, 5, 3);
        znotch1.addBox(0F, 0F, 0F, 1, 1, 2, 0F);
        znotch1.setRotationPoint(-6F, 13F, -8F);
        znotch1.rotateAngleX = 0F;
        znotch1.rotateAngleY = 0F;
        znotch1.rotateAngleZ = 0F;
        znotch1.mirror = false;
        znotch2 = new ModelRenderer(this, 5, 3);
        znotch2.addBox(0F, 0F, 0F, 1, 1, 2, 0F);
        znotch2.setRotationPoint(5F, 13F, -8F);
        znotch2.rotateAngleX = 0F;
        znotch2.rotateAngleY = 0F;
        znotch2.rotateAngleZ = 0F;
        znotch2.mirror = false;
        znotch3 = new ModelRenderer(this, 5, 3);
        znotch3.addBox(0F, 0F, 0F, 1, 1, 2, 0F);
        znotch3.setRotationPoint(-6F, 13F, 6F);
        znotch3.rotateAngleX = 0F;
        znotch3.rotateAngleY = 0F;
        znotch3.rotateAngleZ = 0F;
        znotch3.mirror = false;
        znotch4 = new ModelRenderer(this, 5, 3);
        znotch4.addBox(0F, 0F, 0F, 1, 1, 2, 0F);
        znotch4.setRotationPoint(5F, 13F, 6F);
        znotch4.rotateAngleX = 0F;
        znotch4.rotateAngleY = 0F;
        znotch4.rotateAngleZ = 0F;
        znotch4.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Stick1.render(f5);
        Stick2.render(f5);
        Stick3.render(f5);
        Stick4.render(f5);
        CrossBar1.render(f5);
        CrossBar2.render(f5);
        CrossBar3.render(f5);
        CrossBar4.render(f5);
        xnotch1.render(f5);
        xnotch2.render(f5);
        xnotch3.render(f5);
        xnotch4.render(f5);
        znotch1.render(f5);
        znotch2.render(f5);
        znotch3.render(f5);
        znotch4.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    //fields
    public ModelRenderer Stick1;
    public ModelRenderer Stick2;
    public ModelRenderer Stick3;
    public ModelRenderer Stick4;
    public ModelRenderer CrossBar1;
    public ModelRenderer CrossBar2;
    public ModelRenderer CrossBar3;
    public ModelRenderer CrossBar4;
    public ModelRenderer xnotch1;
    public ModelRenderer xnotch2;
    public ModelRenderer xnotch3;
    public ModelRenderer xnotch4;
    public ModelRenderer znotch1;
    public ModelRenderer znotch2;
    public ModelRenderer znotch3;
    public ModelRenderer znotch4;
}