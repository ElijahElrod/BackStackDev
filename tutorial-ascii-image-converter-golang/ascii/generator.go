package main

import (
	"fmt"
	"image"
	"image/jpeg"
	"log"
	"os"
	"path/filepath"
)

type pixel struct {
	r, g, b, a uint32
}

func main() {
	images := getImages("../images/")
	fmt.Println("Successfully loaded image")
	for i, img := range images {
		for j, pixel := range img {
			//TODO find solution to make larger images display properly
			// 160x160 and 320x320 work decently
			if i / 320 == 1 {fmt.Println()}
			if j % 320 == 0 {fmt.Println()}
			brightness := ((0.21 * float32(pixel.r)) + (0.72 * float32(pixel.g)) + (0.07 * float32(pixel.b))) / 771 // Casted to float32 to resolve truncation error
			fmt.Print(string("`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"[uint32(brightness)/4]))
			fmt.Print(string("`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"[uint32(brightness)/4]))
			fmt.Print(string("`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"[uint32(brightness)/4]))
			

		}
		fmt.Println()
	}
}

func getImages(dir string) [][]pixel {

	var images [][]pixel

	filepath.Walk(dir, func(path string, info os.FileInfo, err error) error {
		if info.IsDir() {
			return nil
		}

		img := loadImage(path)
		pixels := getPixels(img)
		images = append(images, pixels)
		return nil
	})

	return images
}

func loadImage(filename string) image.Image {
	f, err := os.Open(filename)
	if err != nil {
		log.Fatal(err)
	}
	defer f.Close()

	img, err := jpeg.Decode(f)
	if err != nil {
		log.Fatal(err)
	}

	return img
}

func getPixels(img image.Image) []pixel {

	bounds := img.Bounds()
	total := bounds.Dx() * bounds.Dy()
	fmt.Println(bounds.Dx(), " x ", bounds.Dy())
	pixels := make([]pixel, total)

	for i := 0; i < total; i++ {
		x := i % bounds.Dx()
		y := i / bounds.Dx()
		r, g, b, a := img.At(x, y).RGBA()
		pixels[i].r = r
		pixels[i].g = g
		pixels[i].b = b
		pixels[i].a = a
	}

	return pixels

}
