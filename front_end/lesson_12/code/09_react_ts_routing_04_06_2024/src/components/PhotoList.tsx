// rafce
import { useEffect, useState } from "react";
import Photo from "./Photo";
import { Skeleton } from "@mui/material";

export interface IPhotoJson {
  albumId: number;
  id: number;
  title: string;
  url: string;
  thumbnailUrl: string;
}

const PhotoList = () => {
  const [photos, setPhotos] = useState<IPhotoJson[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchPhotos = async () => {
      try {
        const response = await fetch(
          "https://jsonplaceholder.typicode.com/photos"
        );
        const data: IPhotoJson[] = await response.json();
        setPhotos(data.slice(0, 10));
        setIsLoading(false); // объявление загрузки завершённой
      } catch (error) {
        console.log(error);
        setIsLoading(false); // объявление загрузки завершённой
      }
    };

    fetchPhotos();
  }, []);

  return (
    <div className="row">
      {isLoading
        ? Array.from(new Array(10)).map((_, index) => (
            <div className="col-3 mb-4" key={index}>
              <Skeleton variant="rectangular" width="100%" height={200} />
              <Skeleton variant="text" width="80%" />
            </div>
          ))
        : photos.map((photo) => <Photo key={photo.id} photo={photo} />)}
    </div>
  );
};

export default PhotoList;
